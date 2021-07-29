package com.hoppipolla.demoemployeemanagement.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Embeddable;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employeeInfo")
public class EmployeeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String empType;

    @Column(unique = true)
    private String empCode;

    private String emailId;

    @OneToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;



    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeInfo(){}

    public EmployeeInfo(String emailId,  String empType, String empCode, Long id) {
        this.id = id;
        this.empType = empType;
        this.empCode = empCode;
        this.emailId = emailId;
    }


    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }
}
