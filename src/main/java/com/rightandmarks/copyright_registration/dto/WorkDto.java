package com.rightandmarks.copyright_registration.dto;



import lombok.Data;

import java.time.LocalDate;
@Data
public class WorkDto {

    private String title;
    private String description;
    private String type;
    private String dateCreated;
    private String datePublished;
    private String medium;
    private String urlLink;
    private String language;
    private String countryOfFirstPublication;
    private String status;
    private String submittedBy;
}
