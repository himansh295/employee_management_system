package com.hoppipolla.demoemployeemanagement.service;

import com.hoppipolla.demoemployeemanagement.entity.*;
import com.hoppipolla.demoemployeemanagement.repository.*;
import com.hoppipolla.demoemployeemanagement.request.EducationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Slf4j
@Service
public class EmployeeServiceImpl {

    HashMap<Long, Employee> empMap = new HashMap<>();

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

    public String saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Employee Saved";
    }

    public String saveEmployeeCrediantials(Long empId){
        Optional<Employee> e = employeeRepository.findById(empId);
        LocalDate date = e.get().getDate();

        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setEmpType(getEmployeeType(e.get()));
        employeeInfo.setEmpCode(createEmployeeCode(employeeInfo.getEmpType(), e.get()));
        employeeInfo.setEmployee(e.get());
        String fn = e.get().getFirstName();
        String sn = e.get().getLastName();
        int count=0;
        List<Employee> emp = employeeRepository.findAll();
        for(Employee ep:emp){
            if(fn == ep.getFirstName() && sn==ep.getLastName())
                ++count;
        }
        String empEmailId = "";
        if(count>1)
            empEmailId = fn + "." + sn + count + "@hoppipolla.com";
        else
            empEmailId = fn + "." + sn + "@hoppipolla.com";

        employeeInfo.setEmailId(empEmailId);
        employeeInfoRepository.save(employeeInfo);
        return "EmployeeBackground Saved";
    }

    public Optional<Employee> fetchEmployee(Long empIdPassed) {
        Optional<Employee> e = employeeRepository.findById(empIdPassed);
        return e;
    }

    public String saveDepartment(Department dept) {
        departmentRepository.save(dept);
        return "Department is saved in database";
    }



    public String saveBackground(EducationRequest educationRequest){
        //Long id= employeeInfoRepository.getUserByEmpCode(educationRequest.getEmpCode());
        EmployeeInfo employeeInfo= employeeInfoRepository.findByEmpCode(educationRequest.getEmpCode());
        Education education = new Education();
        education.setEmployeeInfo(employeeInfo);
        education.setPreviousdepartment(educationRequest.getPreviousdepartment());
        education.setTotalExperience(educationRequest.getTotalExperience());
        education.setCollegeGraduation(educationRequest.getCollegeGraduation());
        education.setCollegePostGraduation(educationRequest.getCollegePostGraduation());
        education.setDegreeOfGraduation(educationRequest.getDegreeOfGraduation());
        education.setDegreeOfPostGraduation(educationRequest.getDegreeOfPostGraduation());
        education.setPreviousdepartment(educationRequest.getPreviousdepartment());
        education.setPreviousCompany(educationRequest.getPreviousCompany());
        education.setYearOfGraduation(educationRequest.getYearOfGraduation());
        education.setYearOfPostGraduation(educationRequest.getYearOfPostGraduation());
        educationRepsitory.save(education);
        return "Education Background of the employee successfully added";
    }


    private String getEmployeeType(Employee employee){
        LocalDate d2 = LocalDate.now();
        LocalDate d1 = employee.getDate();

        Period period = Period.between(d1, d2);
        long months = period.getMonths() ;
        if(months >= 6 )
            return "FTE";
        else
            return "Intern";
    }

    private String createEmployeeCode(String empType, Employee  employee) {
        int year = employee.getDate().getYear();
        if(empType.equalsIgnoreCase("FTE")){
            return "HOP-"+year+"-FTE-"+employee.getEmpId();
        }else if(empType.equalsIgnoreCase("STE")){
            return "HOP-STE-"+employee.getEmpId();
        }else if(empType.equalsIgnoreCase("Intern")){
            return "HOP-INT-"+employee.getEmpId();
        }
        return null;
    }

    public String deleteUser(Long empId){
        Optional<Employee> e = employeeRepository.findById(empId);
        Optional<EmployeeInfo> ei = employeeInfoRepository.findById(empId);
        employeeInfoRepository.delete(ei.get());
        employeeRepository.delete(e.get());
        return "Employee is Deleted";
    }

    public String getNoBoardedDate(String date)  {
        List<Employee> employee = employeeRepository.findAll();
        int count = 0;

        //DateTimeFormatter dateFormat =  DateTimeFormatter.ofPattern("yyyy-mm-dd");
        LocalDate dt = LocalDate.parse(date);
        for(Employee emp:employee)
        {
            if(dt.getYear() == emp.getDate().getYear() &&
            dt.getMonth() == emp.getDate().getMonth() && dt.getDayOfMonth() == emp.getDate().getDayOfMonth()) {
                ++count;
            }
        }
        String cnt = String.valueOf(count);
        return cnt;
    }
}
