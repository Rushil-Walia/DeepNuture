import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringManipulatorTest {

    @Test
    void testReverse() {
        // Arrange: Set up the object
        StringManipulator manipulator = new StringManipulator();
        
        // Act: Perform the action
        String result = manipulator.reverse("java");
        
        // Assert: Verify the result
        assertEquals("avaj", result, "The string should be reversed");
    }

    @Test
    void testIsPalindrome() {
        StringManipulator manipulator = new StringManipulator();
        
        boolean result = manipulator.isPalindrome("radar");
        
        assertTrue(result, "The word 'radar' is a palindrome");
    }
}