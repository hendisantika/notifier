package id.my.hendisantika.notifier.service.impl;

import id.my.hendisantika.notifier.service.BillingService;
import id.my.hendisantika.notifier.service.CustomerService;
import id.my.hendisantika.notifier.service.NotificationGeneratorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
