package com.hoppipolla.demoemployeemanagement.repository;

import com.hoppipolla.demoemployeemanagement.entity.Education;
import com.hoppipolla.demoemployeemanagement.entity.EmployeeInfo;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepsitory extends JpaRepository<Education,Long> {

    @Query(value = "select totalExperience,previousdepartment from education where emp_code=?", nativeQuery = true)
    public Pair<Integer,String> findByEmpCode(String empCode);

}
