public class CustomerService {
    private final CustomerRepository repository;

    // Constructor Injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void fetchCustomer(int id) {
        System.out.println("Fetching: " + repository.findCustomerById(id));
    }
}