package com.Travel.Agency.Management.Travel.Agency.Management.controller;

import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.Review;
import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.TravelPackage;
import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.User;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.ReviewRepository;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.TravelPackageRepository;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final TravelPackageRepository travelPackageRepository;

    @GetMapping("/add/{packageId}")
    public String showReviewForm(@PathVariable Long packageId, Authentication authentication, Model model) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        TravelPackage pkg = travelPackageRepository.findById(packageId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid package ID"));

        if (pkg.getEndDate().isAfter(java.time.LocalDate.now())) {
            model.addAttribute("error", "You can only review this trip after it has ended.");
            return "redirect:/dashboard";
        }

        if (reviewRepository.existsByUserAndTravelPackage(user, pkg)) {
            model.addAttribute("error", "You already reviewed this trip.");
            return "redirect:/dashboard";
        }

        model.addAttribute("pkg", pkg);
        model.addAttribute("review", new Review());
        return "review-form";
    }

    @PostMapping("/add/{packageId}")
    public String submitReview(@PathVariable Long packageId,
                               @ModelAttribute Review review,
                               Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        TravelPackage pkg = travelPackageRepository.findById(packageId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid package ID"));

        review.setUser(user);
        review.setTravelPackage(pkg);
        review.setCreatedAt(LocalDateTime.now());
        reviewRepository.save(review);

        var reviews = reviewRepository.findByTravelPackage(pkg);
        double avg = reviews.stream().mapToInt(Review::getRating).average().orElse(0);
        pkg.setAverageRating(avg);
        pkg.setReviewCount(reviews.size());
        travelPackageRepository.save(pkg);

        return "redirect:/dashboard";
    }
}
