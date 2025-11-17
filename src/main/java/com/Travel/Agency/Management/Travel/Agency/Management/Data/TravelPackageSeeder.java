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

            TravelPackage pkg6 = new TravelPackage();
            pkg6.setTitle("Safari Adventure in Kenya");
            pkg6.setDestination("Kenya");
            pkg6.setDescription("10 days exploring the wildlife of Maasai Mara with luxury lodges.");
            pkg6.setStartDate(LocalDate.of(2025, 9, 1));
            pkg6.setEndDate(LocalDate.of(2025, 9, 10));
            pkg6.setCapacity(20);
            pkg6.setAvailableSlots(15);
            pkg6.setPricePerPerson(2799.50);
            pkg6.setAverageRating(4.9);
            pkg6.setCreatedAt(LocalDateTime.now());
            pkg6.setImages(List.of("https://images.unsplash.com/photo-1500530855697-b586d89ba3ee"));

            TravelPackage pkg7 = new TravelPackage();
            pkg7.setTitle("Santorini Sunsets");
            pkg7.setDestination("Greece");
            pkg7.setDescription("5 days enjoying Santorini’s beautiful beaches, villages, and sunsets.");
            pkg7.setStartDate(LocalDate.of(2025, 6, 10));
            pkg7.setEndDate(LocalDate.of(2025, 6, 15));
            pkg7.setCapacity(30);
            pkg7.setAvailableSlots(20);
            pkg7.setPricePerPerson(1399.00);
            pkg7.setAverageRating(4.85);
            pkg7.setCreatedAt(LocalDateTime.now());
            pkg7.setImages(List.of("https://tse4.mm.bing.net/th/id/OIP.o3Qga548hAgDwQNLe-EWvgHaE8?rs=1&pid=ImgDetMain&o=7&rm=3"));

            TravelPackage pkg8 = new TravelPackage();
            pkg8.setTitle("Australian Outback Expedition");
            pkg8.setDestination("Australia");
            pkg8.setDescription("7 days exploring the Outback, Uluru, and Aboriginal culture.");
            pkg8.setStartDate(LocalDate.of(2025, 11, 5));
            pkg8.setEndDate(LocalDate.of(2025, 11, 12));
            pkg8.setCapacity(25);
            pkg8.setAvailableSlots(18);
            pkg8.setPricePerPerson(1999.00);
            pkg8.setAverageRating(4.8);
            pkg8.setCreatedAt(LocalDateTime.now());
            pkg8.setImages(List.of("https://images.unsplash.com/photo-1526778548025-fa2f459cd5c1"));

            TravelPackage pkg9 = new TravelPackage();
            pkg9.setTitle("Iceland Northern Lights");
            pkg9.setDestination("Iceland");
            pkg9.setDescription("6 nights chasing the aurora borealis and enjoying geothermal spas.");
            pkg9.setStartDate(LocalDate.of(2025, 12, 1));
            pkg9.setEndDate(LocalDate.of(2025, 12, 7));
            pkg9.setCapacity(20);
            pkg9.setAvailableSlots(12);
            pkg9.setPricePerPerson(2499.00);
            pkg9.setAverageRating(4.95);
            pkg9.setCreatedAt(LocalDateTime.now());
            pkg9.setImages(List.of("https://img.freepik.com/free-photo/vertical-shot-night-winter-landscape-with-northern-lights-reflection-river_181624-54203.jpg?semt=ais_hybrid&w=740&q=80"));

            TravelPackage pkg10 = new TravelPackage();
            pkg10.setTitle("Brazil Carnival Experience");
            pkg10.setDestination("Brazil");
            pkg10.setDescription("7 days in Rio de Janeiro during Carnival with samba shows and parties.");
            pkg10.setStartDate(LocalDate.of(2025, 2, 20));
            pkg10.setEndDate(LocalDate.of(2025, 2, 27));
            pkg10.setCapacity(40);
            pkg10.setAvailableSlots(25);
            pkg10.setPricePerPerson(1799.50);
            pkg10.setAverageRating(4.7);
            pkg10.setCreatedAt(LocalDateTime.now());
            pkg10.setImages(List.of("https://tse2.mm.bing.net/th/id/OIP.oQE6AOTvK4RYiHDhx58WxAHaE8?rs=1&pid=ImgDetMain&o=7&rm=3"));

            travelPackageRepository.saveAll(List.of(pkg1, pkg2, pkg3, pkg4, pkg5, pkg6, pkg7, pkg8, pkg9, pkg10));
            System.out.println("Seeded 10 travel packages successfully!");

        }
    }
}
