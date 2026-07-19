package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        LOGGER.info("Start getAllEmployees");
        LOGGER.info("End getAllEmployees");
        return employeeService.getAllEmployees();
    }

    @PutMapping
    public void updateEmployee(@RequestBody @Valid Employee employee) {
        LOGGER.info("Start updateEmployee");
        employeeService.updateEmployee(employee);
        LOGGER.info("End updateEmployee");
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        LOGGER.info("Start deleteEmployee");
        employeeService.deleteEmployee(id);
        LOGGER.info("End deleteEmployee");
    }
}
