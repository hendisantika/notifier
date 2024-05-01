package id.my.hendisantika.notifier.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : notifier
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/1/24
 * Time: 08:32
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Component
public class NotificationTask implements Task {

    private NotificationGeneratorServiceImpl notificationGeneratorService;
}
