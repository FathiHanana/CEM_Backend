package com.codingcomrades.CEM_fullstack.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonFormat(pattern = "yyyy/MM/dd")

    private Long id;
    private Long ownerid;
    private String createddate;
    private String duedate;
    private double total;
    private double discount;
    private double netamount;





    }

