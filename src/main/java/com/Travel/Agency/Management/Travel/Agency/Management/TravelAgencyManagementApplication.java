package com.Travel.Agency.Management.Travel.Agency.Management;

import com.Travel.Agency.Management.Travel.Agency.Management.model.entity.User;
import com.Travel.Agency.Management.Travel.Agency.Management.model.enums.Role;
import com.Travel.Agency.Management.Travel.Agency.Management.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TravelAgencyManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (userRepository.findByEmail("admin@travel.com").isEmpty()) {
				User admin = new User();
				admin.setFirstName("System");
				admin.setLastName("Admin");
				admin.setEmail("admin@travel.com");
				admin.setPassword(passwordEncoder.encode("admin123"));
				admin.setRole(Role.ADMIN);
				userRepository.save(admin);
				System.out.println("Admin account created: admin@travel.com / admin123");
			}
		};
	}
}