package com.hoppipolla.demoemployeemanagement.entity;


import javax.persistence.*;

@Entity
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eduId;

    @OneToOne
    @JoinColumn(name = "empCode" , referencedColumnName = "empCode")
    private EmployeeInfo employeeInfo;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public Education(){};

    private int totalExperience;
    private String previousCompany;
    private String yearOfGraduation;
    private String yearOfPostGraduation;
    private Boolean degreeOfGraduation;
    private Boolean degreeOfPostGraduation;
    private String collegeGraduation;
    private String collegePostGraduation;
    public String previousdepartment ;



    public Education(Long Id, String previousdepartment, int totalExperience, String previousCompany, String yearOfGraduation, String yearOfPostGraduation, Boolean degreeOfGraduation, Boolean degreeOfPostGraduation, String collegeGraduation, String collegePostGraduation) {

        this.totalExperience = totalExperience;
        this.previousCompany = previousCompany;
        this.yearOfGraduation = yearOfGraduation;
        this.yearOfPostGraduation = yearOfPostGraduation;
        this.degreeOfGraduation = degreeOfGraduation;
        this.degreeOfPostGraduation = degreeOfPostGraduation;
        this.collegeGraduation = collegeGraduation;
        this.collegePostGraduation = collegePostGraduation;
        this.previousdepartment = previousdepartment;
    }

    public String getPreviousdepartment() {
        return previousdepartment;
    }

    public void setPreviousdepartment(String previousdepartment) {
        this.previousdepartment = previousdepartment;
    }

    public Long getEduId() {
        return eduId;
    }

    public void setEduId(Long eduId) {
        this.eduId = eduId;
    }

    public int getTotalExperience() {
        return totalExperience;
    }

    public void setTotalExperience(int totalExperience) {
        this.totalExperience = totalExperience;
    }

    public String getPreviousCompany() {
        return previousCompany;
    }

    public void setPreviousCompany(String previousCompany) {
        this.previousCompany = previousCompany;
    }

    public String getYearOfGraduation() {
        return yearOfGraduation;
    }

    public void setYearOfGraduation(String yearOfGraduation) {
        this.yearOfGraduation = yearOfGraduation;
    }

    public String getYearOfPostGraduation() {
        return yearOfPostGraduation;
    }

    public void setYearOfPostGraduation(String yearOfPostGraduation) {
        this.yearOfPostGraduation = yearOfPostGraduation;
    }

    public Boolean getDegreeOfGraduation() {
        return degreeOfGraduation;
    }

    public void setDegreeOfGraduation(Boolean degreeOfGraduation) {
        this.degreeOfGraduation = degreeOfGraduation;
    }

    public Boolean getDegreeOfPostGraduation() {
        return degreeOfPostGraduation;
    }

    public void setDegreeOfPostGraduation(Boolean degreeOfPostGraduation) {
        this.degreeOfPostGraduation = degreeOfPostGraduation;
    }

    public String getCollegeGraduation() {
        return collegeGraduation;
    }

    public void setCollegeGraduation(String collegeGraduation) {
        this.collegeGraduation = collegeGraduation;
    }

    public String getCollegePostGraduation() {
        return collegePostGraduation;
    }

    public void setCollegePostGraduation(String collegePostGraduation) {
        this.collegePostGraduation = collegePostGraduation;
    }
}
