package com.Travel.Agency.Management.Travel.Agency.Management.services;

import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.Booking;
import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.User;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.BookingRepository;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminManagmentUserService {

    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;

    public AdminManagmentUserService(UserRepository userRepository, BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.bookingRepository=bookingRepository;
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findByFirstName(String name){
        return userRepository.findByFirstName(name);
    }

    public List<User> findByLastName(String lastName){
        return userRepository.findByLastName(lastName);
    }
    public List<Booking> findByUser(User user){
        return bookingRepository.findByUser(user);
    }
    public List<Booking> findByTravelPackageId(Long packageId){
        return bookingRepository.findByTravelPackageId(packageId);
    }
    public Booking addBookingToUser(Long userId, Booking booking) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        booking.setUser(user);
        return bookingRepository.save(booking);
    }
    public long getNumberOfBookingsForPackage(Long packageId) {
        return bookingRepository.sumBookedPeopleByPackageId(packageId);
    }


}
