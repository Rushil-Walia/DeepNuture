// Adaptee (Third-Party with a different interface)
public class StripeGateway {
    public void makePayment(double amountInCents) {
        System.out.println("Stripe processed: " + amountInCents + " cents.");
    }
}