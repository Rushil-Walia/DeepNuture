package com.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {
    @Test
    public void testAdd() {
        CalculatorService calculatorService = new CalculatorService();
        int result = calculatorService.add(2, 3);
        
        assertEquals(5, result, "2 + 3 should equal 5");
    }
}