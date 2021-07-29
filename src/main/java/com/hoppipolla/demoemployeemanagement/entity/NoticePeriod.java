package com.hoppipolla.demoemployeemanagement.entity;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "noticePeriod")
public class NoticePeriod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Timestamp
    private LocalDate dateOfNotice;

    @OneToOne
    @JoinColumn(name = "empCode" , referencedColumnName = "empCode")
    private EmployeeInfo employeeInfo;

    @Timestamp
    private LocalDate dateOfLeaving;

    private String approvalStatus;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public NoticePeriod(){}

    public NoticePeriod(LocalDate dateOfLeaving,Long Id, LocalDate dateOfNotice,String approvalStatus) {
        this.id = Id;
        this.dateOfNotice = dateOfNotice;
        this.approvalStatus = approvalStatus;
        this.dateOfLeaving = dateOfLeaving;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfNotice() {
        return dateOfNotice;
    }

    public void setDateOfNotice(LocalDate dateOfNotice) {
        this.dateOfNotice = dateOfNotice;
    }

    public LocalDate getDateOfLeaving() {
        return dateOfLeaving;
    }

    public void setDateOfLeaving(LocalDate dateOfLeaving) {
        this.dateOfLeaving = dateOfLeaving;
    }
}
