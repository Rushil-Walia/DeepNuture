package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.exception.CountryNotFoundException;
import com.cognizant.springlearn.model.Country;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
    
    // In-memory list for dummy data
    private List<Country> countries = new ArrayList<>();

    public CountryController() {
        countries.add(new Country("IN", "India"));
        countries.add(new Country("US", "United States of America"));
        countries.add(new Country("DE", "Germany"));
        countries.add(new Country("JP", "Japan"));
    }

    @GetMapping
    public List<Country> getAllCountries() {
        LOGGER.info("Start getAllCountries");
        LOGGER.info("End getAllCountries");
        return countries;
    }

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) {
        LOGGER.info("Start getCountry");
        Optional<Country> country = countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst();
        
        if (country.isEmpty()) {
            throw new CountryNotFoundException("Country with code " + code + " not found");
        }
        
        LOGGER.info("End getCountry");
        return country.get();
    }
    
    @PostMapping
    public Country addCountry(@RequestBody @Valid Country country) {
        LOGGER.info("Start addCountry");
        countries.add(country);
        LOGGER.info("End addCountry");
        return country;
    }
}
