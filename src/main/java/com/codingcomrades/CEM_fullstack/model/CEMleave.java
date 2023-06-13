package com.codingcomrades.CEM_fullstack.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CEMleave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonFormat(pattern = "yyyy/MM/dd")

    private Long id;
    private String eid;
    private String leavetype;
    private String startdate;
    private String enddate;
    private String leavestatus;
    private Long noOfDays;

    }

