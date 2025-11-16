package com.Travel.Agency.Management.Travel.Agency.Management.services;

import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.TravelPackage;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.TravelPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TravelPackageService {
    @Autowired
    private final TravelPackageRepository travelPackageRepository;

    public TravelPackageService(TravelPackageRepository travelPackageRepository) {
        this.travelPackageRepository = travelPackageRepository;
    }

    public List<TravelPackage> getAllPackages() {
        return travelPackageRepository.findAll();
    }
}
