package id.my.hendisantika.notifier.service;

import id.my.hendisantika.notifier.model.Billing;

import java.time.Instant;
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
public interface BillingService {

    Iterable<Billing> listAllBillings();

    Billing getBillingById(Long id);

    Billing saveBilling(Billing billing);

    void deleteBilling(Long id);

    List<Billing> findByDueDate(Instant date);
}
