package com.Travel.Agency.Management.Travel.Agency.Management.model.entity;

import java.time.LocalDateTime;

public class Review {
    private Long id;
    private User user;
    private TravelPackage travelPackage;
    private int rating;
    private String comment;
    private LocalDateTime createdAt;

}
