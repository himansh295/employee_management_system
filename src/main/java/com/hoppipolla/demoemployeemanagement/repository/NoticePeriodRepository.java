package com.hoppipolla.demoemployeemanagement.repository;

import com.hoppipolla.demoemployeemanagement.entity.NoticePeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface NoticePeriodRepository extends JpaRepository<NoticePeriod,Long> {

    @Query(value = "select count(*) from notice_period where date_of_leaving=?", nativeQuery = true)
    Long findAllByDateOfLeaving(LocalDate dateOfLeaving);
}
