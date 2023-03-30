package com.mustache.bbshospital.controller;

import com.mustache.bbshospital.domain.entity.Hospital;
import com.mustache.bbshospital.repository.HospitalRepository;
import com.mustache.bbshospital.service.HospitalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/hospitals")
public class HospitalController {

    private final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    /**
     * 병/의원 정보 전체 조회
     */
    @GetMapping("/list")
    public String showList(Model model, @PageableDefault(size = 20, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Hospital> hospitals = hospitalRepository.findAll(pageable);

        model.addAttribute("hospitals", hospitals);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());

        return "boards/list";
    }

    /**
     * 병/의원 정보 단건 조회
     */
    @GetMapping("/{hospitalId}")
    public String getHospital(@PathVariable Integer hospitalId, Model model) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(hospitalId);
        if(optionalHospital.isPresent()) {
            model.addAttribute("hospital", optionalHospital.get());
            return "boards/show";
        } else {
            model.addAttribute("message", String.format("%d번의 병/의원을 찾을 수 없습니다.", hospitalId));
            return "boards/error";
        }
    }

    /**
     * 병/의원 지역명으로 검색
     */
    @GetMapping("/search")
    public String listByRoadName(@RequestParam String keyword, Pageable pageable, Model model) {
//        Page<Hospital> hospitalPage = hospitalRepository.findByRoadNameAddressContaining(keyword, pageable);
        Page<Hospital> hospitalPage = hospitalRepository.findByRoadNameAddressStartsWith(keyword, pageable);
        model.addAttribute("hospitals", hospitalPage);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("keyword", keyword);
        return "boards/list";
    }


}
