package id.my.hendisantika.notifier.controller;

import id.my.hendisantika.notifier.exception.ConflictException;
import id.my.hendisantika.notifier.exception.DuplicateException;
import id.my.hendisantika.notifier.exception.NotFoundException;
import id.my.hendisantika.notifier.model.Customer;
import id.my.hendisantika.notifier.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
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

    @Operation(summary = "Return a customer by ID.", description = "Return a customer by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Customer with specified id does not exist in the system."),
            @ApiResponse(responseCode = "500", description = "Server Internal Error")})
    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@Param(value = "Id of customer") @PathVariable("id") Long id) {
        try {
            Customer result = customerService.getCustomerById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (NotFoundException nfe) {
            log.warn("Customer not found!", nfe);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception ex) {
            log.warn("Problem in findById for Customer!", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(value = "/email")
    @Operation(summary = "Return a customer by email.", description = "Return a customer by email.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Customer with specified email does not exist in the system."),
            @ApiResponse(responseCode = "500", description = "Server Internal Error")})
    public ResponseEntity findByEmail(@Param(value = "Email of customer") @RequestParam("email") String email) {
        try {
            Customer result = customerService.getCustomerByEmail(email);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (NotFoundException nfe) {
            log.warn("Customer with email:{} not found!", email, nfe);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception ex) {
            log.warn("Problem in findByEmail for customer:", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping(consumes = "application/json")
    @Operation(summary = "Create a new customer.",
            description = "Create a new customer and return the URL of the new resource in the Location header.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created in the system."),
            @ApiResponse(responseCode = "400", description = "Bad request."),
            @ApiResponse(responseCode = "409", description = "Customer with specified email already exist in the system."),
            @ApiResponse(responseCode = "500", description = "Server Internal Error")})
    public ResponseEntity add(@RequestBody Customer customer) throws IOException {
        try {
            Customer result = customerService.saveCustomer(customer);
            return ResponseEntity.status(HttpStatus.CREATED).location(new URI("/customers/" + result.getId())).body(null);
        } catch (DuplicateException de) {
            log.warn("Could not add duplicate customer:", de);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } catch (Exception ex) {
            log.warn("Problem while adding customer:", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update an existing customer.", description = "Update an existing customer.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer updated."),
            @ApiResponse(responseCode = "404", description = "Customer does not exist in the system."),
            @ApiResponse(responseCode = "500", description = "Server Internal Error")})
    public ResponseEntity update(@PathVariable Long id, @RequestBody Customer customer) {
        try {
            Customer storedCustomer = customerService.getCustomerById(id);
            storedCustomer.setFirstName(customer.getFirstName());
            storedCustomer.setLastName(customer.getLastName());
            storedCustomer.setEmail(customer.getEmail());
            storedCustomer.setMobile(customer.getMobile());
            customerService.saveCustomer(storedCustomer);
            return ResponseEntity.status(HttpStatus.OK).body("Customer updated successfully");
        } catch (NotFoundException nfe) {
            log.warn("Customer not found!", nfe);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (DuplicateException de) {
            log.warn("Could not update an existing Customer!", de);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } catch (Exception ex) {
            log.warn("Problem in updating Customer!", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete a customer by ID", description = "remove a customer by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer deleted."),
            @ApiResponse(responseCode = "404", description = "Customer with specified id does not exist in the system."),
            @ApiResponse(responseCode = "409", description = "Customer could not be removed, it's used in system!"),
            @ApiResponse(responseCode = "500", description = "Server Internal Error")})
    public ResponseEntity remove(@Param(value = "Id of customer") @PathVariable Long id) {
        try {
            customerService.deleteCustomer(id);
            return ResponseEntity.status(HttpStatus.OK).body("Customer deleted successfully");
        } catch (EmptyResultDataAccessException nfe) {
            log.warn("Customer not found!", nfe);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (ConflictException ce) {
            log.warn("Customer could not be removed, it's used in system!", ce);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } catch (Exception ex) {
            log.warn("Problem in removing Customer!", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
