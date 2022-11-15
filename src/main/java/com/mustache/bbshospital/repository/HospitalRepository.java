package com.mustache.bbshospital.repository;

import com.mustache.bbshospital.domain.entity.Hospital;
import com.mustache.bbshospital.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);
    List<Hospital> findByRoadNameAddressContaining(String roadNameAddresses); // 포함
    List<Hospital> findByRoadNameAddressStartsWith(String roadNameAddresses); // 시작
    List<Hospital> findByHospitalNameEndsWith(String roadNameAddresses); // 끝남
    List<Hospital> findByPatientRoomCountGreaterThanAndPatientRoomCountLessThan(int var1, int var2);






}
