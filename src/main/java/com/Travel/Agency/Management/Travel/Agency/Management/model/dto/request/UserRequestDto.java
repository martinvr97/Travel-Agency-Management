package com.Travel.Agency.Management.Travel.Agency.Management.model.dto.request;

import com.Travel.Agency.Management.Travel.Agency.Management.model.enums.Gender;
import com.Travel.Agency.Management.Travel.Agency.Management.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password; // optional for update
    private LocalDate birthday;
    private String nationality;
    private Gender gender;
    private Role role;
}
