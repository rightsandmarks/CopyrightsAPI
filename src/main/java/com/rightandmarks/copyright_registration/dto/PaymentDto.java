package com.rightandmarks.copyright_registration.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentDto {

    private String amount;
    private String date;
    private String paymentMethod;
    private String status;
    private String invoiceDocument;

}
