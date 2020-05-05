package com.development5053.antiplagiarism.contoller;

import com.development5053.antiplagiarism.model.entity.security.SiteUser;
import com.development5053.antiplagiarism.model.service.DaoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
                                       @RequestParam("username") String username) {
        SiteUser siteUser = new SiteUser(firstName, lastName, username, email, password);
        userDaoService.save(siteUser);

        return "registration";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ValidationResponse login(String error, String logout){
//        ValidationResponse.ValidationResponseBuilder validationResponseBuilder = ValidationResponse.builder();
//        List<String> descriptions = new ArrayList<>();
//        if (error != null){
//            validationResponseBuilder.statusCode("FAIL");
//            descriptions.add(error);
//        }
//        if (logout != null){
//            validationResponseBuilder.statusCode("FAIL");
//            descriptions.add(logout);
//        }else {
//            validationResponseBuilder.statusCode("OK");
//        }
//        return validationResponseBuilder.build();
//    }

}
