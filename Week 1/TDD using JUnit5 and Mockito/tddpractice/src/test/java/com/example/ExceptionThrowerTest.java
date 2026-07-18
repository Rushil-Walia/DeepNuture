package com.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionThrowerTest {

    @Test
    void testThrowException() {
        ExceptionThrower thrower = new ExceptionThrower();
        
        // Assert that the specific exception is thrown
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException();
        });
        
        // Optionally verify the exception message
        assertEquals("This is an expected exception", exception.getMessage());
    }
}