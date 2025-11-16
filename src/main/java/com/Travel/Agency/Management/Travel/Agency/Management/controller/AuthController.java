package com.Travel.Agency.Management.Travel.Agency.Management.controller;

import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.User;
import com.Travel.Agency.Management.Travel.Agency.Management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute("user") User user,
                                  BindingResult result,
                                  Model model) {
        System.out.println("Reached processRegister method!");

        if (result.hasErrors()) {
            result.getAllErrors().forEach(e ->
                    System.out.println("Binding error: " + e.toString()));
            return "register";
        }

        System.out.println("Saving user: " + user.getEmail());
        userService.userRegistration(user);
        model.addAttribute("successMessage", "Registration successful! Please log in.");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
}



