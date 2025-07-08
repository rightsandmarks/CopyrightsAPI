package com.rightandmarks.copyright_registration.dto;

import lombok.Data;

@Data
public class RegistrationDto {

    private UserDto user;
    private WorkDto work;
    private CopyrightApplicationDto application;
    private OwnershipDto ownership;
    private CertificationDto certification;
    private PaymentDto payment;
}
