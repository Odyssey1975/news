package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.forms.UserForm;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    /*@Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    @GetMapping(value = "addUser")
    public String getAddUser() {
        return "addUser";
    }


    @PostMapping(value = "addUser")
    public String postAddCar(UserForm userForm, HttpServletRequest req) {
        List<Role> roles = new ArrayList<>();
        String item = req.getParameter("adm");
        if (item != null) {
            roles.add(new Role(item));
        }
        String item1 = req.getParameter("usr");
        if (item1 != null) {
            roles.add(new Role(item1));
        }
        //passwordEncoder.encode(userForm.getPassword())
        User user = new User(userForm.getName(), userForm.getPassword(), roles);
        userService.add(user);
        return "redirect:/login";

    }

    @GetMapping(value = "/login")
    public String loginPage(Authentication authentication) {
        if (authentication != null) {
            // return "redirect:/user";
            return "redirect:/admin/AllUsers";
        }
        return "login";
    }

    @GetMapping(value = "admin/AllUsers")
    public String getChangeCar(ModelMap modelMap) {
        List<User> users = userService.getUsers();
        modelMap.addAttribute("userInJDBC", users);
        return "crud";
    }

    @PostMapping(value = "admin/deleteUser")
    public String deleteUser(@RequestParam(required = false, name = "Delete") String item) {
        //   String item = req.getParameter("Delete");

        userService.delete(Long.parseLong(item));
        return "redirect:/admin/AllUsers";
    }

    @GetMapping(value = "admin/updateUser")
    // public String getUpdateUser(HttpServletRequest req, ModelMap model) {
    public String getUpdateUser(@RequestParam(required = false, name = "id") Long id, ModelMap model) {
        //  Long id = Long.parseLong(req.getParameter("id"));
        User user = userService.getUserById(id);
        model.addAttribute("User", user);
        return "update";
    }


    @PostMapping(value = "admin/updateUser")
    public String postUpdateUser(UserForm userForm) {

        User user = new User(userForm.getId(), userForm.getName(), userForm.getPassword());
        //passwordEncoder.encode(userForm.getPassword())
        userService.update(user);
        return "redirect:/admin/AllUsers";
    }
}

