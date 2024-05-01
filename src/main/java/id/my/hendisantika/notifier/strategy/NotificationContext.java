package id.my.hendisantika.notifier.strategy;

import id.my.hendisantika.notifier.model.Billing;
import id.my.hendisantika.notifier.model.Customer;
import id.my.hendisantika.notifier.model.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Project : notifier
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/1/24
 * Time: 08:45
 * To change this template use File | Settings | File Templates.
 */
@Component
public class NotificationContext {
    @Autowired
    public void setSmsStrategy(SmsStrategy smsStrategy) {
        strategies.put(NotificationType.SMS, smsStrategy);
    }

    @Autowired
    public void setEmailStrategy(EmailStrategy emailStrategy) {
        strategies.put(NotificationType.EMAIL, emailStrategy);
    }

    private final Map<NotificationType, NotificationStrategy> strategies = new HashMap<>();

    public void generate(NotificationType type, Billing billing, Customer customer) throws Exception {

        strategies.values().stream().filter(strategy -> strategy.match(type)).collect(Collectors.toList()).get(0)
                .generate(billing, customer);
    }
}
