package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.service.*;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;
    private static EmployeeService employeeService;
    @SuppressWarnings("unused")
    private static DepartmentService departmentService;
    @SuppressWarnings("unused")
    private static SkillService skillService;
    @SuppressWarnings("unused")
    private static AttemptService attemptService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        countryService = context.getBean(CountryService.class);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);
        attemptService = context.getBean(AttemptService.class);

        // Uncomment to run tests:
        // testGetAllCountries();
        // testAddCountry();
        // testUpdateCountry();
        // testDeleteCountry();
        // testGetAllPermanentEmployees();
    }

    @SuppressWarnings("unused")
    private static void testGetAllCountries() {
        LOGGER.info("Start testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End testGetAllCountries");
    }

    @SuppressWarnings("unused")
    private static void testAddCountry() {
        LOGGER.info("Start testAddCountry");
        Country c = new Country("ZZ", "Test Country");
        countryService.addCountry(c);
        try {
            Country added = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Added country={}", added);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found");
        }
        LOGGER.info("End testAddCountry");
    }

    @SuppressWarnings("unused")
    private static void testUpdateCountry() {
        LOGGER.info("Start testUpdateCountry");
        try {
            countryService.updateCountry("ZZ", "Updated Country Name");
            Country updated = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Updated country={}", updated);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found");
        }
        LOGGER.info("End testUpdateCountry");
    }

    @SuppressWarnings("unused")
    private static void testDeleteCountry() {
        LOGGER.info("Start testDeleteCountry");
        countryService.deleteCountry("ZZ");
        try {
            countryService.findCountryByCode("ZZ");
        } catch (CountryNotFoundException e) {
            LOGGER.debug("Country successfully deleted and not found.");
        }
        LOGGER.info("End testDeleteCountry");
    }

    @SuppressWarnings("unused")
    private static void testGetAllPermanentEmployees() {
        LOGGER.info("Start testGetAllPermanentEmployees");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees:{}", employees);
        employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
        LOGGER.info("End testGetAllPermanentEmployees");
    }
}
