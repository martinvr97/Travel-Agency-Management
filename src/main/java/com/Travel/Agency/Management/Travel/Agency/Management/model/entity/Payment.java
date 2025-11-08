package com.Travel.Agency.Management.Travel.Agency.Management.model.entity;

import java.time.LocalDateTime;

public class Payment {
    private Long id;
    private Booking booking;
    private PaymentStatus status;
    double amount;
    private LocalDateTime paidAt;
}
