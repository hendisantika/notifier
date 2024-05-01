package id.my.hendisantika.notifier.repository;

import id.my.hendisantika.notifier.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
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
public interface BillingRepository extends JpaRepository<Billing, Long> {

    @Query("select b from Billing b where b.dueDate <= :date and b.notificationStatus ='NEW'")
    List<Billing> findByDueDate(@Param("date") Instant date);
}
