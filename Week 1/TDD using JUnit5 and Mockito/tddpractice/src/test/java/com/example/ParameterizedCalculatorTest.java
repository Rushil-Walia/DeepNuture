package com.example;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedCalculatorTest {

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3",
        "10, 20, 30",
        "-5, 5, 0"
    })
    public void testAddWithMultipleInputs(int a, int b, int expectedResult) {
        CalculatorService calculatorService = new CalculatorService();
        assertEquals(expectedResult, calculatorService.add(a, b));
    }
}