package com.Travel.Agency.Management.Travel.Agency.Management.model.dto.request;

import com.Travel.Agency.Management.Travel.Agency.Management.model.enums.Facility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelPackageRequestDto {
    private String title;
    private String destination;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private int capacity;
    private double pricePerPerson;
    private Set<Facility> facilities;
    private List<String> images;
}

