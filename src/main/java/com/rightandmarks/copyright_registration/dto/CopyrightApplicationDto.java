package com.rightandmarks.copyright_registration.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class CopyrightApplicationDto {
    private String user;
    private String work;
    private String submissionDate;
    private String approvalDate;
    private String status;
    private String comments;
    private String expirationDate;
    private String renewalStatus;




}
