package com.arnasrad.vismainternship;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloCustomerControllerIT {

    @LocalServerPort
    private int port;

    private URL base;

    private final TestRestTemplate template;

    @Autowired
    public HelloCustomerControllerIT(TestRestTemplate template) {

        this.template = template;
    }

    @BeforeEach
    public void setup() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        assertThat(response.getBody().equals("Greetings from Spring Boot!"));
    }
}
