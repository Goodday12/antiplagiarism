package com.development5053.antiplagiarism.contoller;

import com.development5053.antiplagiarism.model.entity.security.SiteUser;
import com.development5053.antiplagiarism.model.service.DaoService;
import com.development5053.antiplagiarism.model.service.impl.DaoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final DaoService<SiteUser> userDaoService;

    public UserController(DaoService<SiteUser> userDaoService) {
        this.userDaoService = userDaoService;
    }

    @PostMapping("/perform-registration")
    public String perform_registration(@RequestParam("firstName") String firstName,
                                       @RequestParam("lastName") String lastName,
                                       @RequestParam("email") String email,
                                       @RequestParam("password") String password,
                                       @RequestParam("username") String username){
        SiteUser siteUser = new SiteUser(firstName, lastName, username, email, password);
        userDaoService.save(siteUser);

    return "registration";
    }

}
