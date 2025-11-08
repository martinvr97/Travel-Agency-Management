package com.Travel.Agency.Management.Travel.Agency.Management.model.dto.response;

import com.Travel.Agency.Management.Travel.Agency.Management.model.enums.Gender;
import com.Travel.Agency.Management.Travel.Agency.Management.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthday;
    private String nationality;
    private Gender gender;
    private Role role;
    private LocalDateTime createdAt;
}