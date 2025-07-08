package com.rightandmarks.copyright_registration.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private CopyrightApplication application;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Double amount;
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String invoiceDocument;

    public enum PaymentMethod {
        CREDIT_CARD, BANK_TRANSFER, DIGITAL_WALLET, OTHER
    }

    public enum Status {
        COMPLETED, PENDING, FAILED
    }
}
