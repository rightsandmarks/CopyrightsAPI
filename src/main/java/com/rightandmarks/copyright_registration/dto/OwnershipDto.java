package com.rightandmarks.copyright_registration.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OwnershipDto {

    private String user;
    private String work;
    private String ownershipPercentage;
    private String dateAcquired;
    private String validTill;
    private String rightsType;
    private String transferStatus;
}
