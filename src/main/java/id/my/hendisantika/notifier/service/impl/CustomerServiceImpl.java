package id.my.hendisantika.notifier.service.impl;

import id.my.hendisantika.notifier.exception.NotFoundException;
import id.my.hendisantika.notifier.model.Customer;
import id.my.hendisantika.notifier.repository.CustomerRepository;
import id.my.hendisantika.notifier.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : notifier
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/1/24
 * Time: 08:39
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> listAllCustomers() {
        log.debug("listAllCustomers called");
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        log.debug("getCustomerById called");
        return Optional.ofNullable(customerRepository.findById(id)).orElseThrow(() ->
                new NotFoundException("Customer with id: " + id + "does not exist."));
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        log.debug("saveCustomer called");
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        log.debug("deleteProduct called");
        customerRepository.deleteById(id);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        log.debug("getCustomerByEmail called");
        return customerRepository.findByEmail(email);
    }

    @Override
    public List<Customer> getCustomersByLastName(String lastName) {
        log.debug("getCustomersByLastName called");
        return customerRepository.findByLastName(lastName);
    }
}
