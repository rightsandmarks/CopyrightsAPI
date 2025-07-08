package com.rightandmarks.copyright_registration.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Certifications")
public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long certificationId;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private CopyrightApplication application;

    private LocalDateTime issuedDate;
    private LocalDate expirationDate;

    @Enumerated(EnumType.STRING)
    private CertificationType certificationType;

    private String certificationFile;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum CertificationType {
        CERTIFICATE_OF_REGISTRATION, OWNERSHIP_TRANSFER_CERTIFICATE, OTHER
    }

    public enum Status {
        ACTIVE, EXPIRED, REVOKED
    }
}
