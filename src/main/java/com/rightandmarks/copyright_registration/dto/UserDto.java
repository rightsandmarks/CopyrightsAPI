package com.rightandmarks.copyright_registration.dto;

import com.rightandmarks.copyright_registration.entity.User;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class UserDto {

    private String name;
    private String email;
    private String phoneNumber;
    private String billAddress;
    private String contAddress;
    private String nationality;
    private String dateOfBirth;
    private String identificationDocument;
    private String role;
    private String registrationDate;

}
