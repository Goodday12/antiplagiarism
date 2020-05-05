package com.development5053.antiplagiarism.contoller;

import com.development5053.antiplagiarism.model.entity.Code;
import com.development5053.antiplagiarism.model.entity.security.SiteUser;
import com.development5053.antiplagiarism.model.service.DaoCodeService;
import com.development5053.antiplagiarism.model.service.DaoService;
import com.development5053.antiplagiarism.util.multipartFileParces.MultipartFileParcer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class CodeLoaderController {

    private final DaoCodeService daoCodeServiceImpl;
    private final DaoService<SiteUser> daoUserService;

    public CodeLoaderController(DaoCodeService daoCodeServiceImpl, DaoService<SiteUser> daoUserService) {
        this.daoCodeServiceImpl = daoCodeServiceImpl;
        this.daoUserService = daoUserService;
    }

    @GetMapping("/load-file")
    public String loadFile() {
        return "load-file";
    }


    @RequestMapping(value = "/sendFile", method = RequestMethod.POST)
    public String sendFile(@RequestParam("file") MultipartFile file) throws IOException {
        String lines = MultipartFileParcer.parceMultipartFile(file);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Code code = new Code();
        SiteUser user = daoUserService.findByName(authentication.getName());
        code.setCode(lines);
        if (user != null) {
            user.addCode(code);
        }

        daoUserService.save(user);
//        daoCodeServiceImpl.save(code);
        return "load-file";
    }


}
