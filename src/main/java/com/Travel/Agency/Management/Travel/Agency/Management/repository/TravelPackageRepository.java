package com.Travel.Agency.Management.Travel.Agency.Management.repository;

import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackage, Long> {
    List<TravelPackage> findByDestinationContainingIgnoreCase(String destination);
    Optional<TravelPackage> findById(Long id);
}

