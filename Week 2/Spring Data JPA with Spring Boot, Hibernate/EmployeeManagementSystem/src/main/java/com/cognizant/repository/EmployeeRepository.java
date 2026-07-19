package com.cognizant.repository;

import com.cognizant.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    // Custom query method using keywords
    List<Employee> findByNameContaining(String name);

    // Custom query method using @Query
    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    Employee findByEmailAddress(String email);
}
