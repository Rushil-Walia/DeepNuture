package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.model.Skill;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDao {
    private static List<Employee> employeeList = new ArrayList<>();

    static {
        Department dept1 = new Department(1L, "IT");
        Department dept2 = new Department(2L, "HR");
        Skill skill1 = new Skill(1L, "Java");
        Skill skill2 = new Skill(2L, "Communication");

        employeeList.add(new Employee(1L, "John Doe", 50000.0, dept1, skill1));
        employeeList.add(new Employee(2L, "Jane Smith", 60000.0, dept2, skill2));
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public void updateEmployee(Employee employee) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(employee.getId())) {
                employeeList.set(i, employee);
                return;
            }
        }
        throw new RuntimeException("Employee not found");
    }

    public void deleteEmployee(Long id) {
        employeeList.removeIf(e -> e.getId().equals(id));
    }
}
