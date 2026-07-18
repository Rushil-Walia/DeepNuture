package com.example;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    void firstExecutionTest() {
        System.out.println("Executing Test 1");
    }

    @Test
    @Order(2)
    void secondExecutionTest() {
        System.out.println("Executing Test 2");
    }
    
    @Test
    @Order(3)
    void thirdExecutionTest() {
        System.out.println("Executing Test 3");
    }
}