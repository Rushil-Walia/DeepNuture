// Test Class
public class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor processor = new StripeAdapter(new StripeGateway());
        processor.processPayment(50.00); // System thinks in dollars, Stripe gets cents
    }
}