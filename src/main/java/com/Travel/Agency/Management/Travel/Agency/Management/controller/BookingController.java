package com.Travel.Agency.Management.Travel.Agency.Management.controller;

import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.Booking;
import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.User;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.BookingRepository;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;

    @GetMapping("/my")
    public String viewMyBookings(Authentication authentication, Model model) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        List<Booking> userBookings = bookingRepository.findByUser(user);

        model.addAttribute("bookings", userBookings);
        model.addAttribute("user", user);
        return "my-bookings";
    }
}
