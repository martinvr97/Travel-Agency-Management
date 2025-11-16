package com.Travel.Agency.Management.Travel.Agency.Management.repository;

import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByTravelPackageId(Long packageId);
    List<Review> findByUserId(Long userId);
}

