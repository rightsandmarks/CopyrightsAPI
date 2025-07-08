package com.rightandmarks.copyright_registration.mapper;

import com.rightandmarks.copyright_registration.dto.RegistrationDto;
import com.rightandmarks.copyright_registration.entity.CopyrightApplication;
import com.rightandmarks.copyright_registration.entity.Payment;
import com.rightandmarks.copyright_registration.entity.User;

import java.time.LocalDateTime;

public class PaymentMapper {

    public static Payment mapToPayment(RegistrationDto registrationDto, Payment payment, CopyrightApplication application, User user){

        payment.setApplication(application);
        payment.setUser(user);
        payment.setAmount(Double.valueOf(registrationDto.getPayment().getAmount()));
        payment.setDate(LocalDateTime.parse(registrationDto.getPayment().getDate()));
        payment.setPaymentMethod(Payment.PaymentMethod.valueOf(registrationDto.getPayment().getPaymentMethod()));
        payment.setStatus(Payment.Status.valueOf(registrationDto.getPayment().getStatus()));
        payment.setInvoiceDocument(registrationDto.getPayment().getInvoiceDocument());
        return payment;
    }
}
