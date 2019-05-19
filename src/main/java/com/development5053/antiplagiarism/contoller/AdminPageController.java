package com.development5053.antiplagiarism.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {

    @GetMapping("/statistic")
    public String statistic(){
    return "get-statistic";
    }

}
