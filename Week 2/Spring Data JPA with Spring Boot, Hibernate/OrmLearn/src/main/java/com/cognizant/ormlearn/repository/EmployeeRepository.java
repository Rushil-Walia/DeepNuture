package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Hands-on 2: HQL with fetch for Eager loading
    @Query(value="SELECT e FROM Employee e left join fetch e.department d left join fetch e.skillList WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    // Hands-on 4: Compute average salary using HQL
    @Query(value="SELECT AVG(e.salary) FROM Employee e")
    double getAverageSalary();
    
    // Hands-on 4: Compute average salary by department using HQL
    @Query(value="SELECT AVG(e.salary) FROM Employee e where e.department.id = :id")
    double getAverageSalaryByDepartment(@Param("id") int id);

    // Hands-on 5: Native query
    @Query(value="SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}
