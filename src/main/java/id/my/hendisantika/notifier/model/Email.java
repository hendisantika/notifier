package id.my.hendisantika.notifier.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Project : notifier
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/1/24
 * Time: 08:24
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email implements Serializable {
    private String to;
    private String content;

}
