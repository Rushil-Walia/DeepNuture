class Product implements Comparable<Product> {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    // Required for Binary Search sorting
    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.productId, other.productId);
    }
}