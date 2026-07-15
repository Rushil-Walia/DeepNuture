package com.cognizant.spring_learn.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// This annotation tells Spring exactly what HTTP status and message to return when this exception is thrown
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country not found")
public class CountryNotFoundException extends Exception {
    
    public CountryNotFoundException() {
        super();
    }
}