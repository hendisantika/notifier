package id.my.hendisantika.notifier.service;

import id.my.hendisantika.notifier.model.Customer;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : notifier
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/1/24
 * Time: 08:34
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerService {

    List<Customer> listAllCustomers();

    Customer getCustomerById(Long id);

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Long id);

    Customer getCustomerByEmail(String email);

    List<Customer> getCustomersByLastName(String email);
}
