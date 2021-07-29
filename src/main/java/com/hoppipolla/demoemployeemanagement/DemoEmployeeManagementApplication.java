package com.hoppipolla.demoemployeemanagement;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.fasterxml.classmate.AnnotationInclusion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hoppipolla.demoemployeemanagement.entity.Employee;
import com.hoppipolla.demoemployeemanagement.entity.EmployeeInfo;
import com.hoppipolla.demoemployeemanagement.repository.EmployeeInfoRepository;
import com.hoppipolla.demoemployeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.annotation.Annotation;

@SpringBootApplication
public class DemoEmployeeManagementApplication  {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeInfoRepository employeeInfoRepository;

	@Autowired
	ObjectMapper objectMapper;

	public static void main(String[] args) {

		SpringApplication.run(DemoEmployeeManagementApplication.class, args);

	}

//	@Override
//	public void run(String... args) throws JsonProcessingException {
//		Employee e = new Employee();
//		e.setFirstName("Himanshu");
//		e.setLastName("Sharma");
//
//		EmployeeInfo ei = new EmployeeInfo();
//		ei.setEmpType("FTE");
//		ei.setEmployee(e);
//
//		employeeRepository.save(e);
//		employeeInfoRepository.save(ei);
//
//		System.out.println(objectMapper.writeValueAsString(e));
//		System.out.println(objectMapper.writeValueAsString(ei));
//	}

}
