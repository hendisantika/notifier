package id.my.hendisantika.notifier.service.impl;

import id.my.hendisantika.notifier.repository.BillingRepository;
import id.my.hendisantika.notifier.service.BillingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * Project : notifier
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/1/24
 * Time: 08:36
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class BillingServiceImpl implements BillingService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private BillingRepository billingRepository;
}
