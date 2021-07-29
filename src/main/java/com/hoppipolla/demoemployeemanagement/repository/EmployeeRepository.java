package com.hoppipolla.demoemployeemanagement.repository;

import com.hoppipolla.demoemployeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
