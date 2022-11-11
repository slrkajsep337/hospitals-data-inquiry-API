package com.mustache.bbshospital;

import com.mustache.bbshospital.domain.entity.Hospital;
import com.mustache.bbshospital.repository.HospitalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BbshospitalApplicationTests {

	@Autowired
	HospitalRepository hr;

	@Test
	void findById() {
		Optional<Hospital> hospital = hr.findById(1);
		Hospital hp = hospital.get();
		System.out.println(hp.getId());
		assertEquals(1, hp.getId());

	}

}
