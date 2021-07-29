package com.hoppipolla.demoemployeemanagement.controller;

import com.hoppipolla.demoemployeemanagement.entity.NoticePeriod;
import com.hoppipolla.demoemployeemanagement.request.NoticePeriodRequest;
import com.hoppipolla.demoemployeemanagement.service.NoticePeriodServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class NoticePeriodRestController {

    @Autowired
    NoticePeriodServiceImpl noticePeriodServiceImpl;

    @PostMapping(value = "/noticePeriod")
    public String postNoticePeriod(@RequestBody NoticePeriodRequest noticePeriodRequest)
    {
        String np = noticePeriodServiceImpl.saveNoticePeriod(noticePeriodRequest);
        return "Notice Period Successfully Added";
    }

    @GetMapping(value = "/employeeLeaving/{date}")
    public String showEmployeeOnboarded(@PathVariable String date){
        return noticePeriodServiceImpl.getLeavingDate(date);
    }
}
