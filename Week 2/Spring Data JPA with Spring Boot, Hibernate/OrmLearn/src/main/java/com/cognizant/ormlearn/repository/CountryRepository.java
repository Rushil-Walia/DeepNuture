package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Hands-on 1: Query Methods
    List<Country> findByNameContaining(String name);
    List<Country> findByNameContainingOrderByNameAsc(String name);
    List<Country> findByNameStartingWith(String letter);
}
