package com.rightandmarks.copyright_registration.mapper;

import com.rightandmarks.copyright_registration.dto.RegistrationDto;
import com.rightandmarks.copyright_registration.entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class UserMapper {

    public static String userIdGenerator(RegistrationDto registrationDto){
        String name = registrationDto.getUser().getName();
        String prefix = name.length()>=3 ? name.substring(0,3) : name;
        // Get the current timestamp
        long timestamp = System.currentTimeMillis();
        // Convert timestamp to a unique string using Base62 encoding
        String uniquePart = encodeBase62(timestamp);
        // Combine prefix with unique part
        return prefix + uniquePart;
    }

    private static String encodeBase62(long value) {
        final String base62Chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder encoded = new StringBuilder();

        while (value > 0) {
            int remainder = (int) (value % 62);
            encoded.insert(0, base62Chars.charAt(remainder));
            value /= 62;
        }
        return encoded.toString();
    }

    public static User mapToUser(RegistrationDto registrationDto, User user){

        user.setName(registrationDto.getUser().getName());
        user.setEmail(registrationDto.getUser().getEmail());
        user.setPhoneNumber(registrationDto.getUser().getPhoneNumber());
        user.setBillAddress(registrationDto.getUser().getBillAddress());
        user.setContAddress(registrationDto.getUser().getContAddress());
        user.setNationality(registrationDto.getUser().getNationality());
        user.setDateOfBirth(LocalDate.parse(registrationDto.getUser().getDateOfBirth()));
        user.setIdentificationDocument(registrationDto.getUser().getIdentificationDocument());
        user.setRole(User.Role.valueOf(registrationDto.getUser().getRole()));
        user.setRegistrationDate(LocalDateTime.parse(registrationDto.getUser().getRegistrationDate()));
        return user;
    }
}
