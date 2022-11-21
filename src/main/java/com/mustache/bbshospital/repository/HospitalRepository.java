package com.mustache.bbshospital.repository;

import com.mustache.bbshospital.domain.entity.Hospital;
import com.mustache.bbshospital.domain.entity.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    //1. 키워드가 포함되어있는 정보 찾기
    //2. 그 찾은 정보를 paging된 형태로 가지고 오기
    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);
    List<Hospital> findByRoadNameAddressContaining(String roadNameAddresses); // 포함
    List<Hospital> findByRoadNameAddressStartsWith(String roadNameAddresses); // 시작
    List<Hospital> findByHospitalNameEndsWith(String roadNameAddresses); // 끝남
    List<Hospital> findByPatientRoomCountGreaterThanAndPatientRoomCountLessThan(int var1, int var2);


    //list.mustache에서 input태그의 keword 값을 가져온다
    Page<Hospital> findByRoadNameAddressContaining(String keyword, Pageable pageable);



}
