package com.mustache.bbshospital.controller;

import com.mustache.bbshospital.domain.dto.HospitalResponse;
import com.mustache.bbshospital.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hospitals")
@RequiredArgsConstructor
public class HospitalRestController {

    private final HospitalService hospitalService;

//    public HospitalRestController(HospitalService hospitalService) {
//        this.hs = hs;
//    }

    /**
     * 병/의원 정보 단건 조회
     */
    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id) {
        HospitalResponse hospitalResponse = hospitalService.getHospital(id);
        return ResponseEntity.ok().body(hospitalResponse);
    }

    /**
     * 병/의원 정보 전체 조회
     */
    @GetMapping(value = "/list")
    public ResponseEntity<Page<HospitalResponse>> listHospital(@PageableDefault(size = 20) @SortDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok().body(hospitalService.getHospitalList(pageable));
    }

}


