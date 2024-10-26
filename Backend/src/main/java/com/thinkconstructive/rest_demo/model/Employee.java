package com.thinkconstructive.rest_demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Employee_information")
@Getter
@Setter
@Data
@RequiredArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;
    private String email;
    private String address;
    @Column(name = "cin")
    private String cin;
    private String accountNumber;
    private String socialSecurityNumber;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String studyNature;
    private String certifications;
    private String educationLevel;
    private Integer yearsOfExperience;
    private String contractType;
    private Double baseSalary;
    private String salaryBenefits;
    private LocalDate contractStartDate;
    private String department;
    private String position;
    private String supervisor;
    private Boolean recommendation;
    private String collaborator;
    private String comment;

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

}
