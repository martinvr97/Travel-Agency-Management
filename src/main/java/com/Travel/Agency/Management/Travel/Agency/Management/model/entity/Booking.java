package com.Travel.Agency.Management.Travel.Agency.Management.model.entity;

import com.Travel.Agency.Management.Travel.Agency.Management.model.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    private TravelPackage travelPackage;

    private int numPeople;
    private double totalPrice;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime confimedAt;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private Payment payment;

}
