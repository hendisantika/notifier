package id.my.hendisantika.notifier.strategy;

import id.my.hendisantika.notifier.model.Billing;
import id.my.hendisantika.notifier.model.Customer;
import id.my.hendisantika.notifier.model.NotificationType;

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
public interface NotificationStrategy {

    boolean match(NotificationType type);

    void generate(Billing billing, Customer customer) throws Exception;
}
