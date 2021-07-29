package com.hoppipolla.demoemployeemanagement.controller;

import com.hoppipolla.demoemployeemanagement.entity.*;
import com.hoppipolla.demoemployeemanagement.request.EducationRequest;
import com.hoppipolla.demoemployeemanagement.request.EmployeeInfoRequest;
import com.hoppipolla.demoemployeemanagement.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Slf4j
@RestController
public class EmployeeRestController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping(value = "/creds")
    public String postEmployeeCrediantials(@RequestBody EmployeeInfoRequest employeeInfoRequest){
        String returnedValue = employeeServiceImpl.saveEmployeeCrediantials(employeeInfoRequest.getEmpId());
        return returnedValue;
    }

    @PostMapping(value = "/user")
    public String postEmployee(@RequestBody Employee emp){
        String returnedValue = employeeServiceImpl.saveEmployee(emp);
        return returnedValue;
    }

    @PostMapping(value = "/department")
    public String postDepartment(@RequestBody Department department)
    {
        String returnedValue = employeeServiceImpl.saveDepartment(department);
        return returnedValue;
    }

    @GetMapping(value = "/user/{empId}")
    public Optional<Employee> getEmployee(@PathVariable Long empId){
        Optional<Employee> e = employeeServiceImpl.fetchEmployee(empId);
        return e;
    }

    @PostMapping(value = "/education")
    public String postBackground(@RequestBody EducationRequest educationRequest)
    {
        String returnedValue = employeeServiceImpl.saveBackground(educationRequest);
        return returnedValue;
    }

    @GetMapping(value = "/onBoarding/{date}")
    public String showEmployeeOnboarded(@PathVariable String date){
        return employeeServiceImpl.getNoBoardedDate(date);
    }

    @DeleteMapping(value = "/user/{empID}")
    public String deleteEmployee(@PathVariable Long empId){
        return employeeServiceImpl.deleteUser(empId);
    }
}
