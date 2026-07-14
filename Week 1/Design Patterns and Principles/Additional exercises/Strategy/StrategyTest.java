public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        context.setPaymentStrategy(new CreditCardPayment());
        context.executePayment(100.0);
        
        context.setPaymentStrategy(new PayPalPayment()); // Swap strategy
        context.executePayment(50.0);
    }
}