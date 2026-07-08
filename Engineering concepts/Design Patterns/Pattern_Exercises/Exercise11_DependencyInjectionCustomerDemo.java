public class Exercise11_DependencyInjectionCustomerDemo {
    public static void main(String[] args) {
        CustomerRepositoryPort repository = new InMemoryCustomerRepository();
        CustomerManagementService service = new CustomerManagementService(repository);

        service.showCustomer(1);
        service.showCustomer(2);
        service.showCustomer(99);
    }
}

interface CustomerRepositoryPort {
    String findCustomerNameById(int customerId);
}

final class InMemoryCustomerRepository implements CustomerRepositoryPort {
    private final java.util.Map<Integer, String> customers = new java.util.HashMap<>();

    InMemoryCustomerRepository() {
        customers.put(1, "Ananya");
        customers.put(2, "Rahul");
        customers.put(3, "Sneha");
    }

    @Override
    public String findCustomerNameById(int customerId) {
        return customers.get(customerId);
    }
}

final class CustomerManagementService {
    private final CustomerRepositoryPort customerRepository;

    CustomerManagementService(CustomerRepositoryPort customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void showCustomer(int customerId) {
        String customerName = customerRepository.findCustomerNameById(customerId);
        if (customerName == null) {
            System.out.println("Customer not found for id " + customerId);
            return;
        }
        System.out.println("Customer " + customerId + ": " + customerName);
    }
}