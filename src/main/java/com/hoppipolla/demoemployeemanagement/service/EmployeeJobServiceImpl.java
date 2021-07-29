package com.hoppipolla.demoemployeemanagement.service;

import com.hoppipolla.demoemployeemanagement.entity.Education;
import com.hoppipolla.demoemployeemanagement.entity.EmployeeInfo;
import com.hoppipolla.demoemployeemanagement.entity.Job;
import com.hoppipolla.demoemployeemanagement.repository.*;
import com.hoppipolla.demoemployeemanagement.request.JobRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class EmployeeJobServiceImpl {

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

    @Autowired
    JobRepository jobRepository;

    public String saveJobDetails(JobRequest jobRequest) {
//        Education education = educationRepsitory.findByEmpCode(jobRequest.getEmpCode());
        EmployeeInfo employeeInfo = employeeInfoRepository.findByEmpCode(jobRequest.getEmpCode());
//        Pair<Integer,String> pp = educationRepsitory.findByEmpCode(jobRequest.getEmpCode());
        Job job = new Job();
        job.setEmployeeInfo(employeeInfo);
        int exp = 100;
        String  dept = "HR";
        job.setExperience(exp/12);
//        String dept = education.getPreviousdepartment();
        if(dept.equalsIgnoreCase("IT"))
        {
            job.setDepartment("IT Team");
            job.setJobBand(itTeam(exp/12));
        }
        else if(dept.equalsIgnoreCase("Recruitment") ||
                dept.equalsIgnoreCase("HR") ||
                dept.equalsIgnoreCase("Founder")){
            job.setDepartment("Corporate Function");
            job.setJobBand(corporate(exp/12,dept));
        }
        else{
            job.setDepartment("Delivery");
            job.setJobBand(corporate(exp/12,dept));
        }

        jobRepository.save(job);
        return "Job detail of Employee Saved in database.";
    }

    private String itTeam(int exp){
        if(exp >= 8 )
            return "Head";
        else
            return "Specialist";
    }

    private String corporate(int exp,String previousDepartment){
        if(previousDepartment.equalsIgnoreCase("Recruitment")){
            if(exp >= 8)
                return "Recruitment Head";
            else
                return "Recruitment Specialist";
        }
        else if(previousDepartment.equalsIgnoreCase("HR")){
            if(exp >= 8)
                return "HR Head";
            else
                return "HR Executive";
        }
        else if(previousDepartment.equalsIgnoreCase("Founder"))
        {
            List<String> list = new ArrayList<>();
            list.add("COO");
            list.add("CBO");
            list.add("CEO");
            list.add("CFO");
            Random rand = new Random();
            return list.get(rand.nextInt(list.size()));
        }
        return null;
    }

    private String delivery(int exp,String previousDepartment){
        if(previousDepartment.equalsIgnoreCase("Devops"))
        {
            if(exp >=0 && exp<=2)
                return "SDE-I";
            else if(exp >2 && exp <= 5)
                return "SDE-II";
            else if(exp >5)
                return "SDE-III";
        }
        else if(previousDepartment.equalsIgnoreCase("Testing"))
        {
            if(exp >=0 && exp<=2)
                return "SDET-I";
            else if(exp >2 && exp <= 5)
                return "SDET-II";
            else if(exp >5 && exp <=8)
                return "SDET-III";
            else if(exp >8 && exp <= 10)
                return "Tech Lead";
            else if(exp > 10)
                return "Engineer Manager";
        }
        else
        {
            if(exp >=0 && exp<=5)
                return "APM";
            else if(exp >5 && exp <= 10)
                return "PM";
            else if(exp >10 && exp <=15)
                return "SPM";
            else if(exp >15 )
                return "DH";
        }
        return null;
    }
}
