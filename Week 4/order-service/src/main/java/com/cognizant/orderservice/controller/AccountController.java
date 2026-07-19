package com.cognizant.orderservice.controller;

import com.cognizant.orderservice.client.CustomerClient;
import com.cognizant.orderservice.dto.CustomerDto;
import com.cognizant.orderservice.entity.Account;
import com.cognizant.orderservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders") // Keeping /orders for consistency with problem statement
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerClient customerClient;

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountRepository.save(account));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<String> getCustomerAccountDetails(@PathVariable Long customerId) {
        CustomerDto customer = customerClient.getCustomerById(customerId);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }

        List<Account> accounts = accountRepository.findByCustomerId(customerId);
        return ResponseEntity.ok("Customer: " + customer.getName() + " | Accounts Count: " + accounts.size() + " | Customer Balance: " + customer.getBalance());
    }
}
