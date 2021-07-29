package com.hoppipolla.demoemployeemanagement.entity;

import jdk.jfr.Timestamp;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    @Column(name = "firstName" , nullable = false)
    private String firstName;

    @Column(name = "lastName" , nullable = false)
    private String lastName;

    @Column(name = "addressDetails")
    private String addressDetails;

    @Column(name = "city")
    private String city;

    @Column(name = "pinCode")
    private String pinCode;

    @Column(name = "state")
    private String state;

    @Column(name = "primaryContact")
    private String primaryContact;

    @Column(name = "secondary_contact")
    private String secondaryContact;

    @Column(name = "createdOn")
    @Timestamp
    private LocalDate createdOn;

    public Employee() {
    }

    public Employee(Long empID,String firstName, String lastName, String addressDetails,
                    String city, String pinCode,String state,String primaryContact,String secondaryContact,LocalDate date) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressDetails = addressDetails;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
        this.primaryContact = primaryContact;
        this.secondaryContact = secondaryContact;
        this.createdOn = date;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }
    public Long getEmpId(){return this.empId;}

    public void setFirstName(String firstName){this.firstName = firstName;}
    public String getFirstName() {return this.firstName;}

    public void setLastName(String lastName){this.lastName = lastName;}
    public String getLastName() {return this.lastName;}

    public void setAddressDetails(String addressDetails){this.addressDetails = addressDetails;}
    public String getAddressDetails() {return this.addressDetails;}

    public void setCity(String city){this.city = city;}
    public String getCity() {return this.city;}

    public void setPinCode(String pinCode){this.pinCode = pinCode;}
    public String getPinCode() {return this.pinCode;}

    public void setPrimaryContact(String primaryContact){this.primaryContact = primaryContact;}
    public String getPrimaryContact() {return this.primaryContact ;}

    public void setSecondaryContact(String secondaryContact){this.secondaryContact = secondaryContact;}
    public String getSecondaryContact() {return this.secondaryContact;}

    public void setDate(LocalDate date){this.createdOn = date;}
    public LocalDate getDate(){return this.createdOn;}

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressDetails='" + addressDetails + '\'' +
                ", city='" + city + '\'' +
                ", pinCode=" + pinCode + '\'' +
                ", primaryContact=" + primaryContact + '\'' +
                ", secondaryContact=" + secondaryContact + '\'' +
                ", createdOn=" + createdOn + '\'' +
                '}';
    }
}
