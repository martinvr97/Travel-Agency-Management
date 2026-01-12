package com.Travel.Agency.Management.Travel.Agency.Management.controller;

import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.Booking;
import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.Review;
import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.User;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.BookingRepository;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.ReviewRepository;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    @GetMapping("/my")
    public String viewMyBookings(Authentication authentication, Model model) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        List<Booking> bookings = bookingRepository.findByUser(user);
        model.addAttribute("bookings", bookings);

        Map<Long, Review> userReviews = reviewRepository.findAll().stream()
                .filter(r -> r.getUser().getId().equals(user.getId()))
                .collect(Collectors.toMap(r -> r.getTravelPackage().getId(), r -> r));
        model.addAttribute("userReviews", userReviews);

        return "my-bookings";
    }
}
