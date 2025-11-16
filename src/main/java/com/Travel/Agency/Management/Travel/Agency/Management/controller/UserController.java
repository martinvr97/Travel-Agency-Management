package com.Travel.Agency.Management.Travel.Agency.Management.controller;

import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.User;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    // 🔹 1. Show user profile
    @GetMapping
    public String viewProfile(Authentication authentication, Model model) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        model.addAttribute("user", user);
        return "profile";
    }

    // 🔹 2. Update user profile
    @PostMapping("/update")
    public String updateProfile(@ModelAttribute("user") User updatedUser, Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setBirthday(updatedUser.getBirthday());
        user.setNationality(updatedUser.getNationality());
        user.setGender(updatedUser.getGender());
        userRepository.save(user);

        return "redirect:/profile?success";
    }

    // 🔹 3. Delete user account
    @PostMapping("/delete")
    public String deleteAccount(Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        userRepository.delete(user);
        return "redirect:/logout";
    }
}
