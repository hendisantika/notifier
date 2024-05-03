package id.my.hendisantika.notifier.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.my.hendisantika.notifier.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by IntelliJ IDEA.
 * Project : notifier
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/3/24
 * Time: 08:58
 * To change this template use File | Settings | File Templates.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFindAll() {
        ResponseEntity<Customer[]> response = restTemplate.getForEntity("/customers", Customer[].class);
        List<Customer> conditions = Arrays.asList(response.getBody());
        assertThat(conditions).isNotNull();
        assertThat(conditions).hasSize(2);
    }

    @Test
    public void testFindById() {
        ResponseEntity<Customer> response = restTemplate.getForEntity("/customers/1", Customer.class);
        Customer condition = response.getBody();
        assertThat(condition).isNotNull();
        assertThat(condition.getId()).isEqualTo(1);
        assertThat(condition.getFirstName()).isEqualTo("Mina");
        assertThat(condition.getLastName()).isEqualTo("Rashidi");
        assertThat(condition.getEmail()).isEqualTo("mina.rashidi.86@gmail.com");
    }

    @Test
    public void testFindByIdWhenDoesNotExist() {
        ResponseEntity<Customer> response = restTemplate.getForEntity("/customers/10", Customer.class);
//        HttpStatus status = response.getStatusCode();
        HttpStatusCode status = response.getStatusCode();
        assertThat(status).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
