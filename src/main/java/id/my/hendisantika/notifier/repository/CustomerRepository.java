package id.my.hendisantika.notifier.repository;

import id.my.hendisantika.notifier.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : notifier
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/1/24
 * Time: 08:28
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c where c.email = :email")
    Customer findByEmail(@Param("email") String email);

    @Query("select c from Customer c where c.lastName = :lastName")
    List<Customer> findByLastName(@Param("lastName") String lastName);
}
