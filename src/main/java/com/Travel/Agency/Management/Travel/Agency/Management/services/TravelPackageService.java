package com.Travel.Agency.Management.Travel.Agency.Management.services;

import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.Booking;
import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.TravelPackage;
import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.User;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.BookingRepository;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.TravelPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelPackageService {
    @Autowired
    private final TravelPackageRepository travelPackageRepository;
    private final BookingRepository bookingRepository;

    public TravelPackageService(TravelPackageRepository travelPackageRepository,BookingRepository bookingRepository) {
        this.travelPackageRepository = travelPackageRepository;
        this.bookingRepository=bookingRepository;
    }

    public List<TravelPackage> getAllPackages() {
        return travelPackageRepository.findAll();
    }

    public List<TravelPackage> findByDestination(String destination){
        return travelPackageRepository.findByDestinationContainingIgnoreCase(destination);
    }
    public List<Booking> findByUser(User user){
        return bookingRepository.findByUser(user);
    }
    public List<Booking> findByTravelPackageId(Long packageId){
        return bookingRepository.findByTravelPackageId(packageId);
    }
    public Booking addBookingToTravelPackage(Long packageId,Booking booking){
        TravelPackage travelPackage1=travelPackageRepository.findById(packageId).
                orElseThrow(()->new RuntimeException("Package not found!"));
        booking.setTravelPackage(travelPackage1);
        return bookingRepository.save(booking);
    }
    public long getNumberOfBookingsForPackage(Long packageId) {
        Long totalPeople = bookingRepository.sumBookedPeopleByPackageId(packageId);
        return totalPeople != null ? totalPeople : 0;
    }
}
