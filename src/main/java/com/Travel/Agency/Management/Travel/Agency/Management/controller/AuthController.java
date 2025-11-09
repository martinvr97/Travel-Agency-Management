package com.Travel.Agency.Management.Travel.Agency.Management.controller;

import com.Travel.Agency.Management.Travel.Agency.Management.model.dto.request.UserRequestDto;
import com.Travel.Agency.Management.Travel.Agency.Management.model.dto.response.UserResponseDto;
import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.User;
import com.Travel.Agency.Management.Travel.Agency.Management.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    @Autowired
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "public/register";
    }
    //BindingResult ehste nje objekt qe mban rezultatin e validimit te formes se input ne front

    @PostMapping("/register")
    public String processRegister(@Valid @ModelAttribute("user") User user,
                                  BindingResult result,
                                  Model model) {
        if (result.hasErrors()) {
            return "public/register";
        }
        userService.userRegistration(user);
        model.addAttribute("successMessage", "Registration successful! Please log in.");
        return "redirect:/login";
    }

        @GetMapping("/login")
        public String showLogin() {
            return "public/login";
        }

    }


