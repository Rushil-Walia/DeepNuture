public class LibrarySearch {
    
    // Linear Search by Title
    public static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) return b;
        }
        return null;
    }

    // Binary Search by Title (Assumes array is already sorted by title alphabetically)
    public static Book binarySearch(Book[] books, String title) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].title.compareToIgnoreCase(title);
            
            if (comparison == 0) return books[mid];
            if (comparison < 0) left = mid + 1; // Target is alphabetically later
            else right = mid - 1; // Target is alphabetically earlier
        }
        return null;
    }
}