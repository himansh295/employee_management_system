package com.hoppipolla.demoemployeemanagement.repository;

import com.hoppipolla.demoemployeemanagement.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {

}
