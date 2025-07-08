package com.rightandmarks.copyright_registration.mapper;

import com.rightandmarks.copyright_registration.dto.RegistrationDto;
import com.rightandmarks.copyright_registration.entity.User;
import com.rightandmarks.copyright_registration.entity.Work;

import java.time.LocalDate;
import java.util.Random;

public class WorkMapper {

    public static String workIdGenerator(){

        String prefix = "WRK";
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
    public static Work mapToWork(RegistrationDto registrationDto, Work work, User user){

        work.setDescription(registrationDto.getWork().getDescription());
        work.setType(Work.Type.valueOf(registrationDto.getWork().getType()));
        work.setDateCreated(LocalDate.parse(registrationDto.getWork().getDateCreated()));
        work.setDatePublished(LocalDate.parse(registrationDto.getWork().getDatePublished()));
        work.setMedium(Work.Medium.valueOf(registrationDto.getWork().getMedium()));
        work.setUrlLink(registrationDto.getWork().getUrlLink());
        work.setLanguage(registrationDto.getWork().getLanguage());
        work.setCountryOfFirstPublication(registrationDto.getWork().getCountryOfFirstPublication());
        work.setStatus(Work.Status.valueOf(registrationDto.getWork().getStatus()));
        work.setUser(user);
        return work;
    }
}
