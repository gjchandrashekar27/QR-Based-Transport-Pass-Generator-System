package com.jsp.QRT.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.jsp.QRT.Model.User;
import com.jsp.QRT.Service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AuthController {
    
    @Autowired
    private UserService userService;

    
    @GetMapping("/")
    public String showDashboard() {
        return "dashboard";  // dashboard.html
    }

    
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    
    @PostMapping("/register")
    public String processRegister(@ModelAttribute("user") @Valid User user,
                                  BindingResult result,
                                  Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        userService.registerUser(user); 
        model.addAttribute("message", "Pass registered successfully!");
        return "success"; 
    }

    
    @GetMapping("/check-aadhaar")
    @ResponseBody
    public ResponseEntity<Boolean> checkAadhaar(@RequestParam String aadhaarNumber) {
        boolean exists = userService.existsByAadhaar(aadhaarNumber);
        return ResponseEntity.ok(exists);
    }

    
    @GetMapping("/check-phone")
    @ResponseBody
    public ResponseEntity<Boolean> checkPhone(@RequestParam String phone) {
        boolean exists = userService.existsByPhone(phone);
        return ResponseEntity.ok(exists);
    }
    
    @GetMapping("/check-email")
    @ResponseBody
    public ResponseEntity<Boolean> checkEmail(@RequestParam String email) {
        boolean exists = userService.existsByEmail(email);
        return ResponseEntity.ok(exists);
    }
    
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login"; 
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("user") User user,
                               HttpSession session,
                               Model model) {
        User loggedInUser = userService.loginUser(user.getAadhaarNumber(), user.getEmail());

        if (loggedInUser != null) {
            session.setAttribute("loggedInUser", loggedInUser);
            return "redirect:/get-pass";  
        } else {
            model.addAttribute("error", "❌ Invalid Aadhaar or Email");
            return "login";
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }


}
