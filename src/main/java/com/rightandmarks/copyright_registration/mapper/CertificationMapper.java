package com.rightandmarks.copyright_registration.mapper;

import com.rightandmarks.copyright_registration.dto.RegistrationDto;
import com.rightandmarks.copyright_registration.entity.Certification;
import com.rightandmarks.copyright_registration.entity.CopyrightApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CertificationMapper {

    public static Certification mapToCertification(RegistrationDto registrationDto, Certification certification,CopyrightApplication application){

        certification.setApplication(application);
        certification.setIssuedDate(LocalDateTime.parse(registrationDto.getCertification().getIssuedDate()));
        certification.setExpirationDate(LocalDate.parse(registrationDto.getCertification().getExpirationDate()));
        certification.setCertificationType(Certification.CertificationType.valueOf(registrationDto.getCertification().getCertificationType()));
        certification.setCertificationFile(registrationDto.getCertification().getCertificationFile());
        certification.setStatus(Certification.Status.valueOf(registrationDto.getCertification().getStatus()));
        return certification;
    }
}
