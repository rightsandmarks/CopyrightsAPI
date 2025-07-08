package com.rightandmarks.copyright_registration.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String email;
    private String phoneNumber;
    private String billAddress;
    private String contAddress;
    private String nationality;

    private LocalDate dateOfBirth;
    private String identificationDocument;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime registrationDate;

    @OneToMany(mappedBy = "user")
    private List<Work> works;

    @OneToMany(mappedBy = "user")
    private List<Ownership> ownerships;

    @OneToMany(mappedBy = "user")
    private List<Payment> payments;

    @OneToMany(mappedBy = "user")
    private List<AuditLog> auditLogs;

    public enum Role {
        INDIVIDUAL, ORGANIZATION, AUTHORIZED_AGENT
    }
}
