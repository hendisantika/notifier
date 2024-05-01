package id.my.hendisantika.notifier.service.impl;

import id.my.hendisantika.notifier.exception.NotFoundException;
import id.my.hendisantika.notifier.model.Billing;
import id.my.hendisantika.notifier.repository.BillingRepository;
import id.my.hendisantika.notifier.service.BillingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : notifier
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/1/24
 * Time: 08:36
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class BillingServiceImpl implements BillingService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private BillingRepository billingRepository;

    @Override
    public Iterable<Billing> listAllBillings() {
        logger.debug("listAllBillings called");
        return billingRepository.findAll();
    }

    @Override
    public Optional<Billing> getBillingById(Long id) {
        logger.debug("getBillingById called");
        return Optional.ofNullable(billingRepository.findById(id)).orElseThrow(() ->
                new NotFoundException("Customer with id: " + id + "does not exist."));
    }

    @Override
    public Billing saveBilling(Billing billing) {
        logger.debug("saveBilling called");
        return billingRepository.save(billing);
    }

    @Override
    public void deleteBilling(Long id) {
        logger.debug("deleteBilling called");
        billingRepository.deleteById(id);
    }

    @Override
    public List<Billing> findByDueDate(Instant date) {
        logger.debug("findByDueDate called");
        return billingRepository.findByDueDate(date);
    }
}
