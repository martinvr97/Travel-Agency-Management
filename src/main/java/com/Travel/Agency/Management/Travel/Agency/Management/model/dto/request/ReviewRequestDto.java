package com.Travel.Agency.Management.Travel.Agency.Management.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequestDto {
    private Long userId;
    private Long travelPackageId;
    private int rating;
    private String comment;
}

