package id.my.hendisantika.notifier.service.impl;

import id.my.hendisantika.notifier.service.EmailService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : notifier
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/1/24
 * Time: 08:42
 * To change this template use File | Settings | File Templates.
 */
@Service
public class EmailServiceImpl implements EmailService {

    private JavaMailSender emailSender;
}
