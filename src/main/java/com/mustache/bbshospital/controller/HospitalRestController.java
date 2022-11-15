package com.mustache.bbshospital.controller;

import com.mustache.bbshospital.domain.entity.Hospital;
import com.mustache.bbshospital.domain.dto.HospitalResponse;
import com.mustache.bbshospital.repository.HospitalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hospitals")  // /api/v1/을 붙여줌으로써 api기능을 한다는 암시를 준다.

//RestController로 하고 싶은 것 -> 데이터를 제공 하는 것
// UI를 통해 제공하는 것 x, JSON(OR XML) 형식으로 데이터를 제공 하는 것
//JSON 형식으로 데이터를 제공 하려면? -> ResponseEntity<HospitalResponse(dto생략)> 이렇게 Return을 해주면 됩니다.
//API란? -> Json형식으로 데이터를 리턴해주는 서버 프로그램
public class HospitalRestController {

    private final HospitalRepository hospitalRepository;

    public HospitalRestController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id) { //ResponseEntity도 DTO타입
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        HospitalResponse hospitalResponse = Hospital.of(hospital.get());
        return ResponseEntity.ok().body(hospitalResponse);
    }
}


