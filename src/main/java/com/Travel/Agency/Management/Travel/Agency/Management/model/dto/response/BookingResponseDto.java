package com.Travel.Agency.Management.Travel.Agency.Management.model.dto.response;

import com.Travel.Agency.Management.Travel.Agency.Management.model.enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDto {
    private Long id;
    private UserResponseDto user;
    private TravelPackageResponseDto travelPackage;
    private int numPeople;
    private double totalPrice;
    private BookingStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime confirmedAt;
    private PaymentResponseDto payment; // optional if payment exists
}
