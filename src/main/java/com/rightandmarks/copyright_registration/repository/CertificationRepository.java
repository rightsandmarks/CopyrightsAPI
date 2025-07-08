package com.rightandmarks.copyright_registration.repository;

import com.rightandmarks.copyright_registration.entity.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationRepository extends JpaRepository<Certification,Long> {
}
