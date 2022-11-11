package com.mustache.bbshospital.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nation_wide_hospitals")
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Hospital {
    @Id
    private Integer id;
    @Column(name = "hospital_name")
    private String title;
    @Column(name = "full_address")
    private String content;

    public Hospital(String title, String content) {
        this.title = title;
        this.content = content;
    }

//    public static Hospital of(Integer id) {
//        return Hospital.builder().id(id).build();
//    }

}
