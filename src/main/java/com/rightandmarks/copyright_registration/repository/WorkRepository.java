package com.rightandmarks.copyright_registration.repository;

import com.rightandmarks.copyright_registration.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends JpaRepository<Work,Long> {

}
