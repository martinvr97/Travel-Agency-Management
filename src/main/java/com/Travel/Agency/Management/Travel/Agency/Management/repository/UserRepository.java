package com.Travel.Agency.Management.Travel.Agency.Management.repository;

import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

