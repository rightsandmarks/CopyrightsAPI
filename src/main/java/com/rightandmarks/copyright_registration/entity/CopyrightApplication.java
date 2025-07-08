package com.rightandmarks.copyright_registration.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Applications")
public class CopyrightApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "work_id", nullable = false)
    private Work work;

    private LocalDateTime submissionDate;
    private LocalDateTime approvalDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String comments;
    private LocalDate expirationDate;

    @Enumerated(EnumType.STRING)
    private RenewalStatus renewalStatus;

    @OneToMany(mappedBy = "application")
    private List<Certification> certifications;

    @OneToMany(mappedBy = "application")
    private List<Payment> payments;

    public enum Status {
        PENDING, APPROVED, REJECTED
    }

    public enum RenewalStatus {
        ACTIVE, EXPIRED
    }
}
