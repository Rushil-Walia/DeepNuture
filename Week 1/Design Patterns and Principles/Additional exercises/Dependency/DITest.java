public class DITest {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo); // Dependency Injected here
        
        service.fetchCustomer(1);
    }
}