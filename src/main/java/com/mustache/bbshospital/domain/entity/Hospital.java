package com.mustache.bbshospital.domain.entity;

import com.mustache.bbshospital.domain.dto.HospitalResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


//dto와 entity 공통점 : 정보를 담고 옮기는 그릇이다
//차이점 :  사용처가 서로다르다. 엔티티 -> DB랑 왔다갔다할때, DTO->컨트롤러랑 웹페이지랑? 왔다갈따할때(dao의 정보를가져올때?)

//엔티티 객체 -> 데이터베이스에 접근하는 계층에서만 사용 ,DTO 객체 -> 다른 계층으로 데이터를 전달할 때 사용

@Entity
@Table(name = "nation_wide_hospitals")
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "road_name_address")
    private String roadNameAddress;

    @Column(name = "hospital_name")
    private String hospitalName;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private String businessTypeName;
    private Float totalAreaSize;
    private Integer businessStatusCode;

    public Hospital(String hospitalName, String roadNameAddress) {
        this.hospitalName = hospitalName;
        this.roadNameAddress = roadNameAddress;
    }

    // HospitalEntity를 HospitalResponse Dto로 만들어주는 부분
    public static HospitalResponse of(Hospital hospital) {
        return new HospitalResponse(hospital.getId(), hospital.getHospitalName(), hospital.getRoadNameAddress(),
                hospital.getPatientRoomCount(), hospital.getTotalNumberOfBeds(), hospital.getBusinessTypeName(),
                hospital.getTotalAreaSize());
    }

}

