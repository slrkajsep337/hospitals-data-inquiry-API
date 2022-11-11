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
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;


@Controller
@RequestMapping("/hospitals")
public class HospitalController {

    private final HospitalRepository hr;
    private final HospitalService hs;

    public HospitalController(HospitalRepository hr, HospitalService hs) {
        this.hr = hr;
        this.hs = hs;
    }

    @GetMapping("")
    public String blankToList() {
        return "redirect:/hospitals/list";
    }


    @GetMapping("/list")
    public String showList(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("hospitals", hs.getHospitalList(pageable));
        return "boards/list";
    }



}
