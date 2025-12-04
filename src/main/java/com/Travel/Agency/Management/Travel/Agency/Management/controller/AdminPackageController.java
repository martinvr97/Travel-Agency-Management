package com.Travel.Agency.Management.Travel.Agency.Management.controller;

import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.TravelPackage;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.TravelPackageRepository;
import com.Travel.Agency.Management.Travel.Agency.Management.services.TravelPackageService; // Import i ndryshuar!
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin/packages")
@RequiredArgsConstructor
public class AdminPackageController {

    private final TravelPackageRepository travelPackageRepository;
    private final TravelPackageService travelPackageService; // Injektimi i ri

    @GetMapping
    public String listPackages(Model model) {
        List<TravelPackage> packageList = travelPackageRepository.findAll();

        Map<Long, Long> bookingCounts = new HashMap<>();
        for (TravelPackage pkg : packageList) {
            long count = travelPackageService.getNumberOfBookingsForPackage(pkg.getId());
            bookingCounts.put(pkg.getId(), count);
        }

        model.addAttribute("packages", packageList);
        model.addAttribute("bookingCounts", bookingCounts);
        return "package-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("pkg", new TravelPackage());
        return "package-form";
    }

    @PostMapping("/create")
    public String createPackage(@ModelAttribute("pkg") TravelPackage pkg,
                                @RequestParam("imageFiles") List<MultipartFile> files) throws IOException {
        List<String> fileUrls = new ArrayList<>();

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
                Path path = Paths.get("src/main/resources/static/uploads/" + filename);
                Files.createDirectories(path.getParent());
                Files.write(path, file.getBytes());
                fileUrls.add("/uploads/" + filename);
            }
        }

        pkg.setImages(fileUrls);
        pkg.setCreatedAt(LocalDateTime.now());
        travelPackageRepository.save(pkg);

        return "redirect:/admin/packages";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        TravelPackage pkg = travelPackageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid package ID"));
        model.addAttribute("pkg", pkg);
        return "package-form";
    }

    @PostMapping("/update/{id}")
    public String updatePackage(@PathVariable Long id,
                                @ModelAttribute("pkg") TravelPackage updatedPkg,
                                @RequestParam("imageFiles") List<MultipartFile> files) throws IOException {
        TravelPackage pkg = travelPackageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid package ID"));

        pkg.setTitle(updatedPkg.getTitle());
        pkg.setDestination(updatedPkg.getDestination());
        pkg.setDescription(updatedPkg.getDescription());
        pkg.setStartDate(updatedPkg.getStartDate());
        pkg.setEndDate(updatedPkg.getEndDate());
        pkg.setCapacity(updatedPkg.getCapacity());
        pkg.setAvailableSlots(updatedPkg.getAvailableSlots());
        pkg.setPricePerPerson(updatedPkg.getPricePerPerson());

        List<String> currentImages = pkg.getImages() != null ? pkg.getImages() : new ArrayList<>();
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
                Path path = Paths.get("src/main/resources/static/uploads/" + filename);
                Files.createDirectories(path.getParent());
                Files.write(path, file.getBytes());
                currentImages.add("/uploads/" + filename);
            }
        }
        pkg.setImages(currentImages);

        travelPackageRepository.save(pkg);
        return "redirect:/admin/packages";
    }

    @GetMapping("/delete/{id}")
    public String deletePackage(@PathVariable Long id) {
        travelPackageRepository.deleteById(id);
        return "redirect:/admin/packages";
    }

    @GetMapping("/search/destination")
    public String searchByDestination(@RequestParam String destination, Model model) {
        List<TravelPackage> pkgList = travelPackageRepository.findByDestinationContainingIgnoreCase(destination);

        Map<Long, Long> bookingCounts = new HashMap<>();
        for (TravelPackage pkg : pkgList) {
            long count = travelPackageService.getNumberOfBookingsForPackage(pkg.getId());
            bookingCounts.put(pkg.getId(), count);
        }

        model.addAttribute("packageList", pkgList);
        model.addAttribute("bookingCounts", bookingCounts);
        model.addAttribute("searchError", pkgList.isEmpty() ? "No package found with destination: " + destination : null);

        return "package-list";
    }
}