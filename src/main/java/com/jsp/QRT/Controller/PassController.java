package com.jsp.QRT.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jsp.QRT.Model.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class PassController {
	
	 @GetMapping("/get-pass")
	    public String showPassPage(HttpSession session, Model model) {
	        User user = (User) session.getAttribute("loggedInUser");

	        if (user == null) {
	            return "redirect:/login"; // Redirect if not logged in
	        }

	        model.addAttribute("user", user);
	        return "get-pass"; // Will render get-pass.html from templates
	    }

}
