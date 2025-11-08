package com.Travel.Agency.Management.Travel.Agency.Management.model.entity;

import java.time.LocalDateTime;

public class Booking {

    private Long id;
    private User user;
    private TravelPackage travelPackage;
    private int numPeople;
    private double totalPrice;
    private BookingStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime confimedAt;
    private Payment payment;

}
