package com.Travel.Agency.Management.Travel.Agency.Management.controller;

import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.Booking;
import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.Payment;
import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.TravelPackage;
import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.User;
import com.Travel.Agency.Management.Travel.Agency.Management.model.enums.BookingStatus;
import com.Travel.Agency.Management.Travel.Agency.Management.model.enums.PaymentStatus;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.BookingRepository;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.PaymentRepository;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.TravelPackageRepository;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/payments")
public class PaymentController {
    private final TravelPackageRepository travelPackageRepository;
    private final BookingRepository bookingRepository;
    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;
    public PaymentController(TravelPackageRepository travelPackageRepository,
                             BookingRepository bookingRepository,
                             PaymentRepository paymentRepository,
                             UserRepository userRepository) {
        this.travelPackageRepository = travelPackageRepository;
        this.bookingRepository = bookingRepository;
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
    }
    @GetMapping("/{packageId}")
    public String showPaymentPage(@PathVariable Long packageId, Model model) {
        TravelPackage selectedPackage = travelPackageRepository.findById(packageId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid package ID: " + packageId));
        model.addAttribute("pkg", selectedPackage);
        return "payment";
    }
    @PostMapping("/confirm/{packageId}")
    public String confirmPayment(@PathVariable Long packageId,
                                 @RequestParam int numPeople,
                                 @RequestParam String method,
                                 Authentication authentication,
                                 Model model) {
        // :white_check_mark: 1. Find user by email (from logged-in session)
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        // :white_check_mark: 2. Get the selected travel package
        TravelPackage pkg = travelPackageRepository.findById(packageId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid package ID: " + packageId));
        // :white_check_mark: 3. Create a new booking
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setTravelPackage(pkg);
        booking.setNumPeople(numPeople);
        booking.setTotalPrice(pkg.getPricePerPerson() * numPeople);
        booking.setStatus(BookingStatus.CONFIRM);
        booking.setCreatedAt(LocalDateTime.now());
        booking.setConfimedAt(LocalDateTime.now());
        bookingRepository.save(booking);
        // :white_check_mark: 4. Create a new payment linked to booking
        Payment payment = new Payment();
        payment.setBooking(booking);
        payment.setStatus(PaymentStatus.SUCCESS);
        payment.setPaidAt(LocalDateTime.now());
        payment.setAmount(booking.getTotalPrice());
        paymentRepository.save(payment);
        // :white_check_mark: 5. Show confirmation details
        model.addAttribute("pkg", pkg);
        model.addAttribute("numPeople", numPeople);
        model.addAttribute("total", booking.getTotalPrice());
        model.addAttribute("method", method);
        model.addAttribute("status", "CONFIRMED");
        return "payment-confirmation";
    }
}
