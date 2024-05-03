package id.my.hendisantika.notifier.service.impl;

import id.my.hendisantika.notifier.model.Email;
import id.my.hendisantika.notifier.service.EmailService;
import id.my.hendisantika.notifier.service.KafkaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : notifier
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/1/24
 * Time: 08:43
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaServiceImpl implements KafkaService {

    private final EmailService emailService;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "notification",
            concurrency = "${spring.kafka.consumer.level.concurrency:3}")
    public void consume(@Payload Email email) {
        log.info("Received <{}>", email);
        emailService.send(email);
    }
}
