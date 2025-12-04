package com.Travel.Agency.Management.Travel.Agency.Management.repository;

import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.Booking;
import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUser(User user);
    List<Booking> findByTravelPackageId(Long packageId);
    //List<Booking> findByBookingStatus(BookingStatus bookingStatus);
    @Query("SELECT SUM(b.numPeople) FROM Booking b WHERE b.travelPackage.id = :packageId")
    Long sumBookedPeopleByPackageId(@Param("packageId") Long packageId);

}

