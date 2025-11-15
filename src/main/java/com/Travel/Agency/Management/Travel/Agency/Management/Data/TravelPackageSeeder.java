package com.Travel.Agency.Management.Travel.Agency.Management.Data;

import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.TravelPackage;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.TravelPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class TravelPackageSeeder implements CommandLineRunner {
    private final TravelPackageRepository travelPackageRepository;
    @Autowired
    public TravelPackageSeeder(TravelPackageRepository travelPackageRepository) {
        this.travelPackageRepository = travelPackageRepository;
    }
    @Override
    public void run(String... args) {
        if (travelPackageRepository.count() == 0) {
            TravelPackage pkg1 = new TravelPackage();
            pkg1.setTitle("Explore Bali");
            pkg1.setDestination("Indonesia");
            pkg1.setDescription("7 days in tropical paradise with private villa stay.");
            pkg1.setStartDate(LocalDate.of(2025, 3, 15));
            pkg1.setEndDate(LocalDate.of(2025, 3, 22));
            pkg1.setCapacity(30);
            pkg1.setAvailableSlots(12);
            pkg1.setPricePerPerson(1499.99);
            pkg1.setAverageRating(4.8);
            pkg1.setCreatedAt(LocalDateTime.now());
            pkg1.setImages(List.of("https://images.unsplash.com/photo-1507525428034-b723cf961d3e"));
            travelPackageRepository.saveAll(List.of(pkg1));
        }
    }
}
