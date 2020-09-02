package web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.security.secDetail.UserDetailesImpl;

public class UsersController {
    @GetMapping(value = "user")
    public String getUser(ModelMap modelMap, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailesImpl userDetails = (UserDetailesImpl) authentication.getPrincipal();
        User user = new User(userDetails.getPassword(), userDetails.getUsername(), userDetails.getUser().getId());

        modelMap.addAttribute("userInJDBC", user);
        return "seeUser";
    }
}
