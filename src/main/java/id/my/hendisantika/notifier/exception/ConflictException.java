package id.my.hendisantika.notifier.exception;

/**
 * Created by IntelliJ IDEA.
 * Project : notifier
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/1/24
 * Time: 08:26
 * To change this template use File | Settings | File Templates.
 */
public class ConflictException extends RuntimeException {

    public ConflictException(String message, Throwable t) {
        super(message, t);
    }
}
