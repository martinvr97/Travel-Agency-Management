package com.Travel.Agency.Management.Travel.Agency.Management.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthday;
    private String nationality;
    private Gender gender;
    private Role role;
    private LocalDateTime createdAt;
    private Set<Booking> bookings;
    private Set<Review> reviews;
}
