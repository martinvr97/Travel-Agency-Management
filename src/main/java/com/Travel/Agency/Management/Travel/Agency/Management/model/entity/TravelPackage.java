package com.Travel.Agency.Management.Travel.Agency.Management.model.entity;

import com.Travel.Agency.Management.Travel.Agency.Management.model.enums.Facility;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "travel_packages")
public class TravelPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String destination;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private int capacity;
    private int availableSlots;
    private double pricePerPerson;
    private double averageRating;
    private int reviewCount;

    //Create a separate table that stores all the facilities for each travel package.
    @ElementCollection(targetClass = Facility.class)
    @Enumerated(EnumType.STRING)
    private Set<Facility> facilities;

    //Create a separate table that stores all the images for each travel package.
    @ElementCollection
    private List<String> images;

    private LocalDateTime createdAt;


    @OneToMany(mappedBy = "travelPackage", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "travelPackage", cascade = CascadeType.ALL)
    private List<Review> reviews;
}
