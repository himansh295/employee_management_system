package com.hoppipolla.demoemployeemanagement.service;


import com.hoppipolla.demoemployeemanagement.entity.EmployeeInfo;
import com.hoppipolla.demoemployeemanagement.entity.NoticePeriod;
import com.hoppipolla.demoemployeemanagement.repository.*;
import com.hoppipolla.demoemployeemanagement.request.NoticePeriodRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
public class NoticePeriodServiceImpl {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeInfoRepository employeeInfoRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    NoticePeriodRepository noticePeriodRepository;

    @Autowired
    EducationRepsitory educationRepsitory;

    public String getLeavingDate(String date){
        Long count = noticePeriodRepository.findAllByDateOfLeaving(LocalDate.parse(date));

//        LocalDate dt = LocalDate.parse(date);
//        for(NoticePeriod np:noticePeriods){
//            if(dt.equals(np.getDateOfLeaving()))
//                ++count;
//        }
        String cnt = String.valueOf(count);
        return cnt;
    }


    public String saveNoticePeriod(NoticePeriodRequest noticePeriodRequest){
        EmployeeInfo employeeInfo= employeeInfoRepository.findByEmpCode(noticePeriodRequest.getEmpCode());
        NoticePeriod noticePeriod = new NoticePeriod();
        noticePeriod.setEmployeeInfo(employeeInfo);
        noticePeriod.setDateOfLeaving(noticePeriodRequest.getDateOfLeaving());
        LocalDate leavingDate = noticePeriodRequest.getDateOfLeaving();
        LocalDate noticeDate = LocalDate.now();
        noticePeriod.setDateOfNotice(noticeDate);

        long days = Duration.between(noticeDate.atStartOfDay(), leavingDate.atStartOfDay()).toDays();
//        Period diff = Period.between(leavingDate,noticeDate);
        int firstIndex = noticePeriodRequest.getEmpCode().indexOf("FTE");
        if(firstIndex != -1)
        {
            if(days >= 45)
                noticePeriod.setApprovalStatus("Approved");
            else
                noticePeriod.setApprovalStatus("Not Approved");
        }
        int fi = noticePeriodRequest.getEmpCode().indexOf("INT");
        if(fi != -1)
        {
            if(days >= 30)
                noticePeriod.setApprovalStatus("Approved");
            else
                noticePeriod.setApprovalStatus("Not Approved");
        }
        noticePeriodRepository.save(noticePeriod);
        return "Notice Period of Employee Successfully Added!!";
    }
}
