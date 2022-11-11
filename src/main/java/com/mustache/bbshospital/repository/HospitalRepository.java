package com.mustache.bbshospital.repository;

import com.mustache.bbshospital.domain.entity.Hospital;
import com.mustache.bbshospital.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
