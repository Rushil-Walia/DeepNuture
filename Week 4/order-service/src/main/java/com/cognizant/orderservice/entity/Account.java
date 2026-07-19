package com.cognizant.orderservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.time.LocalDate;

@Entity
@Table(name = "Accounts")
public class Account {

    @Id
    @Column(name = "AccountID")
    private Long accountId;

    @Column(name = "CustomerID")
    private Long customerId;

    @Column(name = "AccountType")
    private String accountType;

    @Column(name = "Balance")
    private Double balance;

    @Column(name = "LastModified")
    private LocalDate lastModified;

    public Account() {
    }

    public Account(Long accountId, Long customerId, String accountType, Double balance, LocalDate lastModified) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.accountType = accountType;
        this.balance = balance;
        this.lastModified = lastModified;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
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
