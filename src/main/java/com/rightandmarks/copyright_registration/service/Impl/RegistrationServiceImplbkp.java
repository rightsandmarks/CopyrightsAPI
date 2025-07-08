package com.rightandmarks.copyright_registration.service.Impl;

import com.rightandmarks.copyright_registration.dto.RegistrationDto;
import com.rightandmarks.copyright_registration.dto.ResponseDto;
import com.rightandmarks.copyright_registration.entity.*;
import com.rightandmarks.copyright_registration.exception.CustomerAlreadyExistsException;
import com.rightandmarks.copyright_registration.mapper.*;
import com.rightandmarks.copyright_registration.repository.*;
import com.rightandmarks.copyright_registration.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RegistrationServiceImplbkp  {

    private UserRepository userRepository;
    private WorkRepository workRepository;
    private ApplicationRepository applicationRepository;
    private CertificationRepository certificationRepository;
    private OwnershipRepository ownershipRepository;
    private PaymentRepository paymentRepository;

    public ResponseDto registerUser1(RegistrationDto registrationDto) {
        //Validate and Save User
        User user = UserMapper.mapToUser(registrationDto,new User());

        Optional<User> optionalUser =userRepository.findByPhoneNumber(registrationDto.getUser().getPhoneNumber());
        if(optionalUser.isPresent()){
            throw  new CustomerAlreadyExistsException("User already registered with given mobileNumber " + registrationDto.getUser().getPhoneNumber() );
        }

        User savedUser = userRepository.save(user);

        //Save Work
        Work work = WorkMapper.mapToWork(registrationDto,new Work(), user);
        Work savedWork = workRepository.save(work);

        //Save Application
        CopyrightApplication application = ApplicationMapper.mapToApplication(registrationDto,new CopyrightApplication(),user,work);
        CopyrightApplication savedApplication = applicationRepository.save(application);

        //Save Ownership
        Ownership ownership = OwnershipMapper.mapToOwnership(registrationDto,new Ownership(),user,work);
        Ownership savedOwnership = ownershipRepository.save(ownership);

        //Save Certification
        Certification certification = CertificationMapper.mapToCertification(registrationDto,new Certification(),application);
        Certification savedCertification = certificationRepository.save(certification);

        //Save Payment
        Payment payment = PaymentMapper.mapToPayment(registrationDto,new Payment(),application,user);
        Payment savedPayment = paymentRepository.save(payment);


        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatusMessage("Registration successfully completed for the User :" + registrationDto.getUser().getName());
        return responseDto;
    }
}
