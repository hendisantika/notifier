package id.my.hendisantika.notifier.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Created by IntelliJ IDEA.
 * Project : notifier
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/1/24
 * Time: 08:21
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "BILLING")
@SequenceGenerator(name = "S_BILLING", sequenceName = "S_BILLING", allocationSize = 1)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_BILLING")
    @Column(name = "ID")
    private Long id;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "CUSTOMER_ID")
    private long customerId;

    @Column(name = "DUE_DATE")
    private Instant dueDate;

    @Column(name = "NOTIFICATION_STATUS")
    @Enumerated(EnumType.STRING)
    private NotificationStatus notificationStatus;

    @Column(name = "CREATED_DATE")
    private Instant createdDate;

    @Column(name = "CHANGED_DATE")
    private Instant changedDate;
}
