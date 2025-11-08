package com.Travel.Agency.Management.Travel.Agency.Management.model.dto.response;

import com.Travel.Agency.Management.Travel.Agency.Management.model.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDto {
    private Long id;
    private BookingResponseDto booking;
    private PaymentStatus status;
    private double amount;
    private LocalDateTime paidAt;
}