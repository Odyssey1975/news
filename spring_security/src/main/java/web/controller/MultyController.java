package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.forms.UserForm;
import web.model.Role;
import web.model.User;
import web.security.secDetail.UserDetailesImpl;
import web.service.UserService;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MultyController {
    @Autowired
    private UserService userService;


    @GetMapping(value = "addUser")
    public String getAddUser() {
        return "addUser";
    }

    @PostMapping(value = "addUser")
    public String postAddCar(UserForm userForm) {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("ADMIN"));
        User user = new User(userForm.getName(), userForm.getPassword(), roles);
        userService.add(user);
        return "redirect:/login";

    }

    @GetMapping(value = "/login")
    public String loginPage(Authentication authentication) {
        if (authentication != null) {
            // return "redirect:/user";
            return "redirect:/admin/changeUser";
        }
        return "login";
    }

    @GetMapping(value = "user")
    public String getUser(ModelMap modelMap, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailesImpl userDetailes = (UserDetailesImpl) authentication.getPrincipal();
        User user = new User(userDetailes.getPassword(), userDetailes.getUsername(), userDetailes.getUser().getId());
        System.out.println(user);
        modelMap.addAttribute("userInJDBC", user);
        return "seeUser";
    }

    @GetMapping(value = "admin/changeUser")
    public String getChangeCar(ModelMap modelMap) {
        List<User> users = userService.getUsers();
        modelMap.addAttribute("userInJDBC", users);
        return "crud";
    }

    @PostMapping(value = "admin/deleteUser")
    public String deleteCar(HttpServletRequest req) {
        String item = req.getParameter("Delete");
        userService.delete(Long.parseLong(item));
        return "redirect:/admin/changeUser";
    }

    @GetMapping(value = "admin/updateUser")
    public String getUpdateUser(HttpServletRequest req, ModelMap model) {
        Long id = Long.parseLong(req.getParameter("id"));
        User user = userService.getUserById(id);
        model.addAttribute("User", user);
        return "update";
    }

    @PostMapping(value = "admin/updateUser")
    public String postUpdateUser(UserForm userForm) {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("USER"));
        User user = new User(userForm.getId(), userForm.getName(), userForm.getPassword(), roles);
        userService.update(user);
        return "redirect:/admin/changeUser";
    }
}

