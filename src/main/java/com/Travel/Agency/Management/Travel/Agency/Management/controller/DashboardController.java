package com.Travel.Agency.Management.Travel.Agency.Management.controller;

import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.TravelPackage;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.TravelPackageRepository;
import com.Travel.Agency.Management.Travel.Agency.Management.services.TravelPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private final TravelPackageService travelPackageService;
    private final TravelPackageRepository travelPackageRepository;

    public DashboardController(TravelPackageService travelPackageService, TravelPackageRepository travelPackageRepository) {
        this.travelPackageService = travelPackageService;
        this.travelPackageRepository = travelPackageRepository;
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        List<TravelPackage> packages = travelPackageRepository.findAll();
        model.addAttribute("packages", packages);
        return "dashboard";
    }
}
