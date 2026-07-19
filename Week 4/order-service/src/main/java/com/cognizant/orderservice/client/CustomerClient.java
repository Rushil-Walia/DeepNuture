package com.cognizant.orderservice.client;

import com.cognizant.orderservice.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service") // Keep name as user-service for routing
public interface CustomerClient {

    @GetMapping("/users/{id}")
    CustomerDto getCustomerById(@PathVariable("id") Long id);
}
