package com.cognizant.userservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.time.LocalDate;

@Entity
@Table(name = "Customers")
public class Customer {

    @Id
    @Column(name = "CustomerID")
    private Long customerId;

    @Column(name = "Name")
    private String name;

    @Column(name = "DOB")
    private LocalDate dob;

    @Column(name = "Balance")
    private Double balance;

    @Column(name = "LastModified")
    private LocalDate lastModified;

    public Customer() {
    }

    public Customer(Long customerId, String name, LocalDate dob, Double balance, LocalDate lastModified) {
        this.customerId = customerId;
        this.name = name;
        this.dob = dob;
        this.balance = balance;
        this.lastModified = lastModified;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDate getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDate lastModified) {
        this.lastModified = lastModified;
    }
}
