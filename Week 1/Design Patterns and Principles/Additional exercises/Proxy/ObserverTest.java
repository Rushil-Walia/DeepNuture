public class ObserverTest {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        market.register(new MobileApp());
        market.setPrice(150.50); // Mobile app automatically reacts
    }
}