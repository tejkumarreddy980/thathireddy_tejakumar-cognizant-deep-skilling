public class DependencyInjectionExample {

    static class Customer {
        private String id;
        private String name;

        public Customer(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    interface CustomerRepository {
        Customer findCustomerById(String id);
    }

    static class CustomerRepositoryImpl implements CustomerRepository {
        public Customer findCustomerById(String id) {
            return new Customer(id, "Customer_" + id);
        }
    }

    static class CustomerService {
        private CustomerRepository customerRepository;

        public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        public void getCustomerDetails(String id) {
            Customer customer = customerRepository.findCustomerById(id);
            System.out.println("Customer Details:");
            System.out.println("ID   : " + customer.getId());
            System.out.println("Name : " + customer.getName());
        }
    }

    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        System.out.println("== Fetching Customer ==");
        service.getCustomerDetails("C101");
    }
}
