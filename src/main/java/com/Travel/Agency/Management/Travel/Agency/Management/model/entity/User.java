package com.Travel.Agency.Management.Travel.Agency.Management.model.entity;

import com.Travel.Agency.Management.Travel.Agency.Management.model.enums.Gender;
import com.Travel.Agency.Management.Travel.Agency.Management.model.enums.Role;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;


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
