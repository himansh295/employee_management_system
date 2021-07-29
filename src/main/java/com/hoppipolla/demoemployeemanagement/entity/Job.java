package com.hoppipolla.demoemployeemanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobBand;
    private String department;
    private int experience;

    @OneToOne
    @JoinColumn(name = "empCode" , referencedColumnName = "empCode")
    private EmployeeInfo employeeInfo;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public Job(){}

    public Job(Long id, String jobBand, String department,int experience) {
        this.id = id;
        this.jobBand = jobBand;
        this.department = department;
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobBand() {
        return jobBand;
    }

    public void setJobBand(String jobBand) {
        this.jobBand = jobBand;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }



}
