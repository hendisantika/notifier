package id.my.hendisantika.notifier.repository;

import id.my.hendisantika.notifier.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * Project : notifier
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/3/24
 * Time: 08:55
 * To change this template use File | Settings | File Templates.
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() throws Exception {
        customerRepository.deleteAll();

        Customer customer1 = new Customer();
        customer1.setFirstName("Itadori");
        customer1.setLastName("Yuji");
        customer1.setEmail("yuji@yopmail.com");
        customer1.setMobile("1234567");

        Customer customer2 = new Customer();
        customer2.setFirstName("Gojo");
        customer2.setLastName("Satoru");
        customer2.setEmail("gojo@yopmail.com");
        customer2.setMobile("8765432");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
    }

    @Test
    public void testLoadCustomers() {
        List<Customer> customers = customerRepository.findAll();
        assertEquals("Did not get all customers", 2, customers.size());
    }

    @Test
    public void testFindByLastName() {
        // given
        Customer customer = new Customer();
        customer.setFirstName("Itadori");
        customer.setLastName("Yuji");
        customer.setEmail("yuji@yopmail.com");
        customer.setFirstName("9876543");
        entityManager.persist(customer);

        // when
        List<Customer> customers = customerRepository.findByLastName(customer.getLastName());

        // then
        assertEquals("Found wrong number of Rashidi Ups", 1, customers.size());
        assertEquals("Found wrong last name", "Rashidi", customers.get(0).getLastName());
    }

    @Test
    public void testCRUD() throws Exception {
        // Create a new game
        Customer customer = new Customer();
        customer.setFirstName("Itadori");
        customer.setLastName("Yuji");
        customer.setEmail("yuji@yopmail.com");
        customer.setFirstName("9876543");
        customerRepository.save(customer);

        // Assert it was created
        List<Customer> customers = customerRepository.findByLastName(customer.getLastName());
        assertEquals("Did not find customer", customer.getLastName(), customers.get(0).getLastName());

        // Edit the lastName
        String newLastName = "Khaki";
        customers.get(0).setLastName(newLastName);
        customerRepository.save(customer);

        // Assert it updated
        List<Customer> updatedCustomer = customerRepository.findByLastName(customer.getLastName());
        assertEquals("Did not update last name", newLastName, updatedCustomer.get(0).getLastName());

        // Delete customer
        customerRepository.delete(updatedCustomer.get(0));
        // Assert not found
        List<Customer> emptyCustomer = customerRepository.findByLastName(customer.getLastName());
        assertEquals("Should have returned no customers", 0, emptyCustomer.size());
    }

}
