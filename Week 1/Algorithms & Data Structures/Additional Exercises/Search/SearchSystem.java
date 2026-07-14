public class SearchSystem {
    // Linear Search: Checks element by element
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.productId == targetId) return p;
        }
        return null;
    }

    // Binary Search: Halves the search area (requires sorted array)
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].productId == targetId) return products[mid];
            if (products[mid].productId < targetId) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }
}