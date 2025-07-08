package com.rightandmarks.copyright_registration.repository;

import com.rightandmarks.copyright_registration.entity.CopyrightApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<CopyrightApplication,Long> {
}
