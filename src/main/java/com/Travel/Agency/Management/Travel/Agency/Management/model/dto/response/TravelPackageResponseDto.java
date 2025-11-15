package com.Travel.Agency.Management.Travel.Agency.Management.model.dto.response;

import com.Travel.Agency.Management.Travel.Agency.Management.model.enums.Facility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelPackageResponseDto {
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
    private Set<Facility> facilities;
    private List<String> images;
    private LocalDateTime createdAt;
}
