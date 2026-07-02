import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    // This is our "Test Fixture" - the object we are testing
    private ShoppingCart cart;

    // --- SETUP METHOD ---
    // Runs before EVERY single @Test method. 
    // Ensures a fresh, empty cart for every test, preventing data bleed.
    @BeforeEach
    void setUp() {
        System.out.println("Running @BeforeEach: Initializing a new ShoppingCart");
        cart = new ShoppingCart();
    }

    // --- TEARDOWN METHOD ---
    // Runs after EVERY single @Test method.
    // Used to clean up resources (closing database connections, files, etc.).
    @AfterEach
    void tearDown() {
        System.out.println("Running @AfterEach: Emptying the cart and cleaning up\n");
        cart.emptyCart();
        cart = null; 
    }

    // --- TESTS USING AAA PATTERN ---

    @Test
    void testAddItem() {
        // Arrange: We have an empty cart from setUp(), let's define the item to add
        String itemToAdd = "Laptop";

        // Act: Perform the action we are actually trying to test
        cart.addItem(itemToAdd);

        // Assert: Verify the cart's state changed correctly
        assertEquals(1, cart.getItemCount(), "Cart should contain exactly 1 item after adding");
    }

    @Test
    void testRemoveItem() {
        // Arrange: Add an item first so we have something to remove
        cart.addItem("Headphones");
        assertEquals(1, cart.getItemCount()); // Optional pre-assertion

        // Act: Remove the item
        cart.removeItem("Headphones");

        // Assert: Verify the cart is empty again
        assertEquals(0, cart.getItemCount(), "Cart should be empty after removing the only item");
    }
}