package com.rightandmarks.copyright_registration.mapper;

import com.rightandmarks.copyright_registration.dto.RegistrationDto;
import com.rightandmarks.copyright_registration.entity.Ownership;
import com.rightandmarks.copyright_registration.entity.User;
import com.rightandmarks.copyright_registration.entity.Work;

import java.time.LocalDate;

public class OwnershipMapper {

    public static Ownership mapToOwnership(RegistrationDto registrationDto, Ownership ownership, User user, Work work){

        ownership.setUser(user);
        ownership.setWork(work);
        ownership.setOwnershipPercentage(Double.valueOf(registrationDto.getOwnership().getOwnershipPercentage()));
        ownership.setDateAcquired(LocalDate.parse(registrationDto.getOwnership().getDateAcquired()));
        ownership.setValidTill(LocalDate.parse(registrationDto.getOwnership().getValidTill()));
        ownership.setRightsType(Ownership.RightsType.valueOf(registrationDto.getOwnership().getRightsType()));
        ownership.setTransferStatus(Ownership.TransferStatus.valueOf(registrationDto.getOwnership().getTransferStatus()));
        return ownership;
    }
}
