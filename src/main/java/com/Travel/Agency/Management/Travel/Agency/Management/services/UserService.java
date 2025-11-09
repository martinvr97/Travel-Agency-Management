package com.Travel.Agency.Management.Travel.Agency.Management.services;

import com.Travel.Agency.Management.Travel.Agency.Management.model.dto.response.UserResponseDto;
import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.User;
import com.Travel.Agency.Management.Travel.Agency.Management.model.enums.Role;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //Metoda register a new user

    public User userRegistration(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRole() == null)
            user.setRole(Role.USER);
        return userRepository.save(user);
    }

    public List<User> getAllUsers () {
        return userRepository.findAll();
    }

    public Optional<User> findByEmail (String email) {
        return userRepository.findByEmail(email);
    }




    public void updateUser(User user){
        User existing= userRepository.findById(user.getId())
                .orElseThrow(()->new RuntimeException("User not found"));
                existing.setFirstName(existing.getFirstName());
                existing.setLastName(existing.getLastName());
                existing.setEmail(existing.getEmail());
                existing.setPassword(existing.getPassword());
                existing.setBirthday(existing.getBirthday());
                existing.setNationality(existing.getNationality());
                existing.setGender(existing.getGender());
                existing.setRole(existing.getRole());
                existing.setCreatedAt(existing.getCreatedAt());
    }
}
