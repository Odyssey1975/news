package web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.security.secDetail.UserDetailsImpl;

@Controller
public class UserController {
    @GetMapping(value = "user")
    public String getUser(ModelMap modelMap, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = new User(userDetails.getPassword(), userDetails.getUsername(), userDetails.getUser().getId());
       // System.out.println(user);
        modelMap.addAttribute("userInJDBC", user);
        return "seeUser";
    }



  /*  @GetMapping(value = "user")
    public String seeUser(ModelMap modelMap, Authentication authentication) {
        modelMap.addAttribute("user",  authentication.getPrincipal());
        return "seeUser";
    }*/
}