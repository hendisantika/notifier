package id.my.hendisantika.notifier.service;

import id.my.hendisantika.notifier.exception.NotFoundException;
import id.my.hendisantika.notifier.model.Customer;
import id.my.hendisantika.notifier.repository.CustomerRepository;
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

}
