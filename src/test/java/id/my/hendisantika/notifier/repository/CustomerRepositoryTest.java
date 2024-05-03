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
}
