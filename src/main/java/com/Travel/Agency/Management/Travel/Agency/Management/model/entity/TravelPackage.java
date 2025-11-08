package com.Travel.Agency.Management.Travel.Agency.Management.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String destination;
    private String description;
    private LocalDate startdate;
    private LocalDate endDate;
    private int capacity;
    private int availableSlots;
    private double priceperPerson;
    private double averageRating;
    private int reviewCount;
    private Set<Facility> facilities;
    private List<String> images;
    private LocalDateTime createdAt;
    private List<Booking> bookings;
    private List<Review> reviews;

}
