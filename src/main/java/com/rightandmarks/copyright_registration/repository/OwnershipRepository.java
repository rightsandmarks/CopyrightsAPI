package com.rightandmarks.copyright_registration.repository;

import com.rightandmarks.copyright_registration.entity.Ownership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnershipRepository extends JpaRepository<Ownership,Long> {
}
