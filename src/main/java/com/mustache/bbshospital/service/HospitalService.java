package com.mustache.bbshospital.service;

import com.mustache.bbshospital.domain.entity.Hospital;
import com.mustache.bbshospital.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class HospitalService {

    @Autowired
    HospitalRepository hr;

    @Transactional
    public Page<Hospital> getHospitalList(Pageable pageable) {
        return hr.findAll(pageable);
    }
}

