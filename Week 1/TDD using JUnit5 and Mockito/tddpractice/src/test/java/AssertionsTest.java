import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    void testVariousAssertions() {
        // 1. Assert Equals: Checks if two values are exactly the same
        assertEquals(5, 2 + 3, "2 + 3 should equal 5");

        // 2. Assert True: Checks if a boolean condition evaluates to true
        assertTrue(5 > 3, "5 is greater than 3");

        // 3. Assert False: Checks if a boolean condition evaluates to false
        assertFalse(5 < 3, "5 is not less than 3");

        // 4. Assert Null: Checks if an object is null
        String emptyString = null;
        assertNull(emptyString, "The string should be null");

        // 5. Assert Not Null: Checks if an object has been instantiated
        Object myObject = new Object();
        assertNotNull(myObject, "The object should not be null");

        // 6. Assert Throws (JUnit 5 Specific): Verifies that a specific exception is thrown
        assertThrows(ArithmeticException.class, () -> {
            int dummy  = 10 / 0;
        }, "Dividing by zero must throw an ArithmeticException");
    }
}