public class StringManipulator {
    
    // Reverses a given string
    public String reverse(String input) {
        if (input == null) return null;
        return new StringBuilder(input).reverse().toString();
    }

    // Checks if a string reads the same forwards and backwards
    public boolean isPalindrome(String input) {
        if (input == null) return false;
        String reversed = reverse(input);
        return input.equals(reversed);
    }
}