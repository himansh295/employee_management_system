package com.hoppipolla.demoemployeemanagement.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NoticePeriodRequest {

    private String empCode;
    private LocalDate dateOfLeaving;
}
