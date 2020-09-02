package web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.security.secDetail.UserDetailesImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
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
}