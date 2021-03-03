package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import guru.springfamework.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;
    private VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Category Loaded = " + categoryRepository.count());

        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFirstName("Joe");
        customer1.setLastName("Newman");

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setFirstName("Michael");
        customer2.setLastName("Lachappele");

        Customer customer3 = new Customer();
        customer3.setId(3L);
        customer3.setFirstName("Susan");
        customer3.setLastName("Tanner");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        System.out.println("Customer Loaded = " + customerRepository.count());

        Vendor vendor1 = new Vendor();
        vendor1.setId(1L);
        vendor1.setName("Alfa");

        Vendor vendor2 = new Vendor();
        vendor2.setId(2L);
        vendor2.setName("Beat");

        Vendor vendor3 = new Vendor();
        vendor3.setId(3L);
        vendor3.setName("Teta");

        vendorRepository.save(vendor1);
        vendorRepository.save(vendor2);
        vendorRepository.save(vendor3);

        System.out.println("Vendor Loaded = " + vendorRepository.count());
    }
}
