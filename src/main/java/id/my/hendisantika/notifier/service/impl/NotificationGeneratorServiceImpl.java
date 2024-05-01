package id.my.hendisantika.notifier.service.impl;

import id.my.hendisantika.notifier.model.Billing;
import id.my.hendisantika.notifier.model.Customer;
import id.my.hendisantika.notifier.model.NotificationStatus;
import id.my.hendisantika.notifier.model.NotificationType;
import id.my.hendisantika.notifier.service.BillingService;
import id.my.hendisantika.notifier.service.CustomerService;
import id.my.hendisantika.notifier.service.NotificationGeneratorService;
import id.my.hendisantika.notifier.strategy.NotificationContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : notifier
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/1/24
 * Time: 08:44
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationGeneratorServiceImpl implements NotificationGeneratorService {

    private final CustomerService customerService;
    private final BillingService billingService;
    private final NotificationContext notificationContext;

    public void generate() {
        Instant tomorrow = Instant.now().plus(1, ChronoUnit.DAYS);
        List<Billing> billings = billingService.findByDueDate(tomorrow);

        billings.forEach((Billing billing) -> {
            try {
                Optional<Customer> customer = customerService.getCustomerById(billing.getCustomerId());
                for (NotificationType type : NotificationType.values()) {
                    notificationContext.generate(type, billing, customer.orElse(null));
                }

                billing.setNotificationStatus(NotificationStatus.GENERATED);
                billing.setChangedDate(Instant.now());
                billingService.saveBilling(billing);

            } catch (Exception e) {
                billing.setNotificationStatus(NotificationStatus.FAILED);
                billing.setChangedDate(Instant.now());
                billingService.saveBilling(billing);
            }
        });
    }
}
