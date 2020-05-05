package com.development5053.antiplagiarism.contoller;

import com.development5053.antiplagiarism.model.entity.Code;
import com.development5053.antiplagiarism.model.service.DaoCodeService;
import com.development5053.antiplagiarism.model.service.FinderWorker;
import com.development5053.antiplagiarism.model.service.impl.FinderWorkerImpl;
import com.development5053.antiplagiarism.util.multipartFileParces.MultipartFileParcer;
import com.development5053.antiplagiarism.util.similirityFinder.MatchingBlock;
import com.development5053.antiplagiarism.util.similirityFinder.SimilarityFinder;
import javafx.util.Pair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class CheckerController {

    @Autowired
    DaoCodeService daoCodeService;

    @GetMapping("/code-checker")
    public String codeChecker() {
        return "code-checker";
    }

    @PostMapping("/check")
    public String check(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        String lines = MultipartFileParcer.parceMultipartFile(file);
        SimilarityFinder similarityFinder = new SimilarityFinder();
        FinderWorker finderWorker = new FinderWorkerImpl(similarityFinder);
        List<Code> all = daoCodeService.findAll();
        List<MatchingBlock> matchingBlocks = new ArrayList<>();
        Set<Double> scores = new HashSet<>();
        all.forEach(e -> {
            scores.add(finderWorker.lookForSimilarities(lines, e.getCode(), SimilarityFinder.Lang.CPP, matchingBlocks));
        });
        model.addAttribute("plag", scores.stream().max(Comparator.comparing(Double::doubleValue)).get() * 100);

        return "code-checker";
    }

    @RequestMapping(value = "/teacher-check", method = POST)
    public String teacherCheck(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        String lines = MultipartFileParcer.parceMultipartFile(file);
        FinderWorker finderWorker = new FinderWorkerImpl(new SimilarityFinder());
        List<Code> all = daoCodeService.findAll();
        List<MatchingBlock> blocks = new ArrayList<>();
        List<Pair<Double, List<MatchingBlock>>> map = new ArrayList<>();

        JSONObject response = new JSONObject();
        JSONArray code_to_check_plagiarism_matches = new JSONArray();
        JSONArray base_codes_plagiarism_matches = new JSONArray();
        JSONArray similarity_coefficients = new JSONArray();

//        SimilarityFinder finder = new SimilarityFinder();

        for (Code code : all) {
            String base_code = code.toString();

            JSONArray code_to_check_match = new JSONArray();
            JSONArray base_code_match = new JSONArray();
            List<MatchingBlock> plagiarism_matches = new ArrayList<>();
            double similarity_coefficient =
                    finderWorker.lookForSimilarities(lines, base_code, SimilarityFinder.Lang.CPP, plagiarism_matches);
            for (MatchingBlock matchingBlock : plagiarism_matches) {
                code_to_check_match.put(matchingBlock.original);
                base_code_match.put(matchingBlock.plag);
            }
            code_to_check_plagiarism_matches.put(code_to_check_match);
            base_codes_plagiarism_matches.put(base_code_match);
            similarity_coefficients.put(similarity_coefficient);
        }

        response.put("code_to_check_plagiarism_matches", code_to_check_plagiarism_matches);
        response.put("base_codes_plagiarism_matches", base_codes_plagiarism_matches);
        response.put("similarity_coefficients", similarity_coefficients);

//        return response.toString();
//
//        all.forEach(e -> {
//            double v = finderWorker.lookForSimilarities(lines, e.getCode(), SimilarityFinder.Lang.CPP, blocks);
//            map.add(new Pair<>(v,new ArrayList<>(blocks)));
//            blocks.clear();
//        });

//        map.forEach( m -> {
//            System.out.println(m.getKey());
//            m.getValue().forEach(System.out::println);
//        });


        model.addAttribute("obj", response.toString());


        return "code-checker";
    }


}
