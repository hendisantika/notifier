package id.my.hendisantika.notifier.strategy.impl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import id.my.hendisantika.notifier.model.Billing;
import id.my.hendisantika.notifier.model.Customer;
import id.my.hendisantika.notifier.model.Email;
import id.my.hendisantika.notifier.model.NotificationType;
import id.my.hendisantika.notifier.strategy.NotificationStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : notifier
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/1/24
 * Time: 08:47
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class EmailStrategy implements NotificationStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailStrategy.class);

    private final Configuration freeMarkerConfiguration;
    private final JmsTemplate jmsTemplate;

    @Override
    public boolean match(NotificationType type) {
        return type == NotificationType.EMAIL;
    }

    @Override
    public void generate(Billing billing, Customer customer) throws Exception {

        Map<String, Object> model = new HashMap<>();
        model.put("billing", billing);
        model.put("customer", customer);

        Template template = freeMarkerConfiguration.getTemplate("email.ftl");
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        Email email = new Email(customer.getEmail(), content);
        jmsTemplate.convertAndSend("notifier.email", email);
    }
}
