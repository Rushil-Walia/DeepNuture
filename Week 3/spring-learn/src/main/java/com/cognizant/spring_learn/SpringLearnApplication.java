package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        
        // Invoke the displayDate method
        displayDate();
		displayCountries();
    }


	public static void displayDate() {
        LOGGER.info("START displayDate");
        
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        
        try {
            Date date = format.parse("31/12/2018");
            LOGGER.debug(date.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        LOGGER.info("END displayDate");
		context.close();
    }

    // --- Hands-on 4 Method ---
    public static void displayCountries() {
        LOGGER.info("START displayCountries");
        
        // Initialize context
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        
        // Retrieve the ArrayList bean
        java.util.ArrayList<Country> countries = (java.util.ArrayList<Country>) context.getBean("countryList");
        
        // Display the list using debug log
        LOGGER.debug("Country List : {}", countries);
        
        LOGGER.info("END displayCountries");
		context.close();
    
    }
}