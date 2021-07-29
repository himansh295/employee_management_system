package com.hoppipolla.demoemployeemanagement.controller;

import com.hoppipolla.demoemployeemanagement.entity.Job;
import com.hoppipolla.demoemployeemanagement.request.JobRequest;
import com.hoppipolla.demoemployeemanagement.service.EmployeeJobServiceImpl;
import com.hoppipolla.demoemployeemanagement.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeJobRestController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    EmployeeJobServiceImpl employeeJobServiceImpl;

    @PostMapping(value = "/jobType")
    public String postJobDetails(@RequestBody JobRequest jobRequest){
        employeeJobServiceImpl.saveJobDetails(jobRequest);
        return "Job of employee Successfully added";
    }

}
