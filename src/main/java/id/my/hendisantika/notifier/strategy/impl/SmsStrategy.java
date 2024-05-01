package id.my.hendisantika.notifier.strategy.impl;

import freemarker.template.Configuration;
import id.my.hendisantika.notifier.model.NotificationType;
import id.my.hendisantika.notifier.strategy.NotificationStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : notifier
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/1/24
 * Time: 08:49
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SmsStrategy implements NotificationStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmsStrategy.class);

    private final Configuration freeMarkerConfiguration;
    private final JmsTemplate jmsTemplate;

    @Override
    public boolean match(NotificationType type) {
        return type == NotificationType.SMS;
    }
}
