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

            TravelPackage pkg2 = new TravelPackage();
            pkg2.setTitle("Romantic Escape to Paris");
            pkg2.setDestination("France");
            pkg2.setDescription("5 days of art, culture, and romance — including Eiffel Tower dinner.");
            pkg2.setStartDate(LocalDate.of(2025, 4, 10));
            pkg2.setEndDate(LocalDate.of(2025, 4, 15));
            pkg2.setCapacity(40);
            pkg2.setAvailableSlots(25);
            pkg2.setPricePerPerson(1899.00);
            pkg2.setAverageRating(4.7);
            pkg2.setCreatedAt(LocalDateTime.now());
            pkg2.setImages(List.of("https://images.unsplash.com/photo-1502602898657-3e91760cbb34"));

            TravelPackage pkg3 = new TravelPackage();
            pkg3.setTitle("Tokyo City Adventure");
            pkg3.setDestination("Japan");
            pkg3.setDescription("8 days exploring Tokyo’s culture, food, and high-tech attractions.");
            pkg3.setStartDate(LocalDate.of(2025, 7, 5));
            pkg3.setEndDate(LocalDate.of(2025, 7, 12));
            pkg3.setCapacity(35);
            pkg3.setAvailableSlots(18);
            pkg3.setPricePerPerson(2299.50);
            pkg3.setAverageRating(4.9);
            pkg3.setCreatedAt(LocalDateTime.now());
            pkg3.setImages(List.of("https://images.unsplash.com/photo-1549693578-d683be217e58"));

            TravelPackage pkg4 = new TravelPackage();
            pkg4.setTitle("Luxury Maldives Retreat");
            pkg4.setDestination("Maldives");
            pkg4.setDescription("6 nights of pure relaxation in overwater villas with ocean views.");
            pkg4.setStartDate(LocalDate.of(2025, 8, 20));
            pkg4.setEndDate(LocalDate.of(2025, 8, 26));
            pkg4.setCapacity(25);
            pkg4.setAvailableSlots(10);
            pkg4.setPricePerPerson(2599.99);
            pkg4.setAverageRating(4.95);
            pkg4.setCreatedAt(LocalDateTime.now());
            pkg4.setImages(List.of("https://letsgomaldives.com/wp-content/uploads/2015/11/amari-havodda-23932-1450x816.jpg"));

            TravelPackage pkg5 = new TravelPackage();
            pkg5.setTitle("New York Highlights Tour");
            pkg5.setDestination("USA");
            pkg5.setDescription("6 days exploring New York City’s most iconic attractions.");
            pkg5.setStartDate(LocalDate.of(2025, 10, 1));
            pkg5.setEndDate(LocalDate.of(2025, 10, 6));
            pkg5.setCapacity(50);
            pkg5.setAvailableSlots(33);
            pkg5.setPricePerPerson(1599.00);
            pkg5.setAverageRating(4.7);
            pkg5.setCreatedAt(LocalDateTime.now());
            pkg5.setImages(List.of("https://lp-cms-production.imgix.net/2020-11/shutterstockRF_259501811.jpg?auto=format&fit=crop&sharp=10&vib=20&ixlib=react-8.6.4&w=850&q=35&dpr=3"));
            travelPackageRepository.saveAll(List.of(pkg1, pkg2, pkg3, pkg4, pkg5));
            System.out.println(":white_check_mark: Seeded 5 travel packages successfully!");
        }
    }
}
