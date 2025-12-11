package com.Travel.Agency.Management.Travel.Agency.Management.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseDto {
    private Long id;
    private UserResponseDto user;
    private TravelPackageResponseDto travelPackage;
    private int rating;
    private String comment;
    private LocalDateTime createdAt;
}
