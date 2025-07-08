package com.rightandmarks.copyright_registration.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "Works")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workId;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Type type;

    private LocalDate dateCreated;
    private LocalDate datePublished;

    @Enumerated(EnumType.STRING)
    private Medium medium;

    private String urlLink;
    private String language;
    private String countryOfFirstPublication;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "work")
    private List<CopyrightApplication> applications;

    @OneToMany(mappedBy = "work")
    private List<Ownership> ownerships;

    public enum Type {
        LITERARY, MUSICAL, VISUAL, OTHER
    }

    public enum Medium {
        DIGITAL, PHYSICAL
    }

    public enum Status {
        REGISTERED, PENDING, REJECTED
    }
}
