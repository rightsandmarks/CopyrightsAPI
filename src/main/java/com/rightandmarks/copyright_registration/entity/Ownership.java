package com.rightandmarks.copyright_registration.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Ownerships")
public class Ownership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownershipId;

    @ManyToOne
    @JoinColumn(name = "work_id", nullable = false)
    private Work work;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Double ownershipPercentage;
    private LocalDate dateAcquired;
    private LocalDate validTill;

    @Enumerated(EnumType.STRING)
    private RightsType rightsType;

    @Enumerated(EnumType.STRING)
    private TransferStatus transferStatus;

    public enum RightsType {
        REPRODUCTION, DISTRIBUTION, PERFORMANCE, OTHER
    }

    public enum TransferStatus {
        ACTIVE, TRANSFERRED, EXPIRED
    }
}
