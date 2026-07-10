public class DecoratorTest {
    public static void main(String[] args) {
        Notifier multiNotifier = new SMSNotifierDecorator(new EmailNotifier());
        multiNotifier.send("Server is down!");
    }
}