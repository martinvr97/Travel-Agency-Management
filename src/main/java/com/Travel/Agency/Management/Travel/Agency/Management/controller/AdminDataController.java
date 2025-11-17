package com.Travel.Agency.Management.Travel.Agency.Management.controller;

import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.User;
import com.Travel.Agency.Management.Travel.Agency.Management.model.enums.Role;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.TravelPackageRepository;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/users")
public class AdminDataController {
    private final UserRepository userRepository;
    private final TravelPackageRepository travelPackageRepository;

    public AdminDataController(UserRepository userRepository, TravelPackageRepository travelPackageRepository) {
        this.userRepository = userRepository;
        this.travelPackageRepository = travelPackageRepository;
    }

    @GetMapping
    public String listUser(Model model) {
        model.addAttribute("userList", userRepository.findAll());
        return "user-list";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "User not found!");
        } else if (user.getRole() == Role.ADMIN) {
            redirectAttributes.addFlashAttribute("errorMessage", "Admin users cannot be deleted!");
        } else {
            userRepository.delete(user);
            redirectAttributes.addFlashAttribute("successMessage", "User deleted successfully!");
        }
        return "redirect:/admin/users";
    }

}

