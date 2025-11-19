package com.Travel.Agency.Management.Travel.Agency.Management.services;

import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.User;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminManagmentUserService {

    private final UserRepository userRepository;

    public AdminManagmentUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findByFirstName(String name){
        return userRepository.findByFirstName(name);
    }

    public List<User> findByLastName(String lastName){
        return userRepository.findByLastName(lastName);
    }

}
