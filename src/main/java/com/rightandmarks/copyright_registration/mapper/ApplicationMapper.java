package com.rightandmarks.copyright_registration.mapper;

import com.rightandmarks.copyright_registration.dto.RegistrationDto;
import com.rightandmarks.copyright_registration.entity.CopyrightApplication;
import com.rightandmarks.copyright_registration.entity.User;
import com.rightandmarks.copyright_registration.entity.Work;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ApplicationMapper {

    public static CopyrightApplication mapToApplication(RegistrationDto registrationDto,CopyrightApplication application, User user, Work work){

        application.setUser(user);
        application.setWork(work);
        application.setSubmissionDate(LocalDateTime.parse(registrationDto.getApplication().getSubmissionDate()));
        application.setApprovalDate(LocalDateTime.parse(registrationDto.getApplication().getApprovalDate()));
        application.setStatus(CopyrightApplication.Status.valueOf(registrationDto.getApplication().getStatus()));
        application.setComments(registrationDto.getApplication().getComments());
        application.setExpirationDate(LocalDate.parse(registrationDto.getApplication().getExpirationDate()));
        application.setRenewalStatus(CopyrightApplication.RenewalStatus.valueOf(registrationDto.getApplication().getRenewalStatus()));
        return application;

    }

}
