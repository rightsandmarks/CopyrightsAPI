package com.rightandmarks.copyright_registration.controller;

import com.rightandmarks.copyright_registration.dto.RegistrationDto;
import com.rightandmarks.copyright_registration.dto.ResponseDto;
import com.rightandmarks.copyright_registration.exception.ValidationException;
import com.rightandmarks.copyright_registration.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/copyright")
@AllArgsConstructor
public class RegistrationController {


    private RegistrationService registrationService;
    @PostMapping(value = "/registration", produces = "application/json", consumes = "application/json")
    private ResponseEntity<ResponseDto> registerUser(@RequestBody RegistrationDto registrationDto)  {

        ResponseDto response = registrationService.registerUser(registrationDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
