package id.my.hendisantika.notifier.service;

import id.my.hendisantika.notifier.model.Email;

/**
 * Created by IntelliJ IDEA.
 * Project : notifier
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/1/24
 * Time: 08:35
 * To change this template use File | Settings | File Templates.
 */
public interface KafkaService {

    void consume(Email email);
}
