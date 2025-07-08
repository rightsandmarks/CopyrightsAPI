package com.rightandmarks.copyright_registration.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CertificationDto {

    private String application;
    private String issuedDate;
    private String expirationDate;
    private String certificationType;
    private String certificationFile;
    private String status;
}
