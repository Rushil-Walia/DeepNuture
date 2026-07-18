package com.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PerformanceTesterTest {
    
    // Approach 1: Using the @Timeout annotation
    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void testPerformTaskWithAnnotation() throws InterruptedException {
        PerformanceTester tester = new PerformanceTester();
        tester.performTask();
    }

    // Approach 2: Using the assertTimeout assertion method
    @Test
    void testPerformTaskWithAssertion() {
        PerformanceTester tester = new PerformanceTester();
        
        assertTimeout(Duration.ofSeconds(1), () -> {
            tester.performTask();
        }, "The task exceeded the 1-second timeout limit.");
    }
}