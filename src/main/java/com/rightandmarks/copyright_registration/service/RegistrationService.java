package com.rightandmarks.copyright_registration.service;

import com.rightandmarks.copyright_registration.dto.RegistrationDto;
import com.rightandmarks.copyright_registration.dto.ResponseDto;



public interface RegistrationService {

    ResponseDto registerUser (RegistrationDto registrationDto) ;
}
