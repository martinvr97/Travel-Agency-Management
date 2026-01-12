package com.Travel.Agency.Management.Travel.Agency.Management.controller;

import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.User;
import com.Travel.Agency.Management.Travel.Agency.Management.model.enums.Role;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.TravelPackageRepository;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.UserRepository;
import com.Travel.Agency.Management.Travel.Agency.Management.services.AdminManagmentUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/users")
public class AdminDataController {
    private final UserRepository userRepository;
    private final TravelPackageRepository travelPackageRepository;
    private final AdminManagmentUserService adminManagmentUserService;

    public AdminDataController(UserRepository userRepository, TravelPackageRepository travelPackageRepository,AdminManagmentUserService adminManagmentUserService) {
        this.userRepository = userRepository;
        this.travelPackageRepository = travelPackageRepository;
        this.adminManagmentUserService=adminManagmentUserService;
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

    @GetMapping("/search/name")
    public String searchByName(@RequestParam String keyword, Model model) {
        List<User> users = adminManagmentUserService.findByFirstName(keyword);

        model.addAttribute("userList", users);
        model.addAttribute("searchError", users.isEmpty() ? "No users found with name: " + keyword : null);
        return "user-list";
    }

    @GetMapping("/search/lastName")
    public String searchByLastName(@RequestParam String keyword, Model model) {
        List<User> users = adminManagmentUserService.findByLastName(keyword);

        model.addAttribute("userList", users);
        model.addAttribute("searchError", users.isEmpty() ? "No users found with last name: " + keyword : null);
        return "user-list";
    }

    @GetMapping("/search/email")
    public String getUserByEmail(@RequestParam String email, Model model) {
        Optional<User> userOpt = adminManagmentUserService.findByEmail(email);
        if (userOpt.isPresent()) {
            model.addAttribute("userList", List.of(userOpt.get()));
            model.addAttribute("searchError", null);
        } else {
            model.addAttribute("userList", List.of());
            model.addAttribute("searchError", "No user found with email: " + email);
        }
        return "user-list";
    }


}

