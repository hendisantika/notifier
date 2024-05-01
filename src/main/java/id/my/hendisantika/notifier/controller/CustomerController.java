package id.my.hendisantika.notifier.controller;

import id.my.hendisantika.notifier.model.Customer;
import id.my.hendisantika.notifier.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
@Tag(name = "customers", description = "Customer Api")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @Operation(summary = "Return all customers.", description = "Returns list of all customers.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found"),
            @ApiResponse(responseCode = "500", description = "Server Internal Error")})
    @GetMapping
    public ResponseEntity findAll() {
        try {
            List<Customer> result = customerService.listAllCustomers();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            log.warn("Problem in findAll customers:", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
