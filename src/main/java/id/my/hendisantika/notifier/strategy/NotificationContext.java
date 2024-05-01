package id.my.hendisantika.notifier.strategy;

import id.my.hendisantika.notifier.model.NotificationType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

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

    private final Map<NotificationType, NotificationStrategy> strategies = new HashMap<>();
}
