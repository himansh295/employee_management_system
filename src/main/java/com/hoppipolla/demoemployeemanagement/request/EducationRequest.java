package com.hoppipolla.demoemployeemanagement.request;

import lombok.Data;

@Data
public class EducationRequest {

    private String empCode;
    private int totalExperience;
    private String previousCompany;
    private String yearOfGraduation;
    private String yearOfPostGraduation;
    private Boolean degreeOfGraduation;
    private Boolean degreeOfPostGraduation;
    private String collegeGraduation;
    private String collegePostGraduation;
    public String previousdepartment ;
}
