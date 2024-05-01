package id.my.hendisantika.notifier.controller;

import id.my.hendisantika.notifier.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : notifier
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/1/24
 * Time: 16:30
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestController
@RequestMapping("/customers")
@Api(value = "customers", description = "Customer Api", tags = {"customer-api"}, consumes = "application/json")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
}
