package com.hoppipolla.demoemployeemanagement.repository;

import com.hoppipolla.demoemployeemanagement.entity.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo,Long> {

    @Query(value = "Select ei.empId from employeeInfo ei where ei.empCode=?"
            , nativeQuery = true)
    public Long getUserByEmpCode(String empCode);

    EmployeeInfo findByEmpCode(String empCode);
}
