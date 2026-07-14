public class Main {
    public static void main(String[] args) {
        // Array must be sorted by Title alphabetically for Binary Search to work!
        Book[] library = {
            new Book(3, "Clean Architecture", "Robert C. Martin"),
            new Book(1, "Clean Code", "Robert C. Martin"),
            new Book(4, "Design Patterns", "Gang of Four"),
            new Book(2, "Effective Java", "Joshua Bloch"),
            new Book(5, "Pragmatic Programmer", "Andrew Hunt")
        };

        System.out.println("--- Linear Search ---");
        Book foundLinear = LibrarySearch.linearSearch(library, "Effective Java");
        System.out.println("Found: " + (foundLinear != null ? foundLinear.author : "Not Found"));

        System.out.println("\n--- Binary Search ---");
        Book foundBinary = LibrarySearch.binarySearch(library, "Clean Code");
        System.out.println("Found: " + (foundBinary != null ? foundBinary.author : "Not Found"));
    }
}