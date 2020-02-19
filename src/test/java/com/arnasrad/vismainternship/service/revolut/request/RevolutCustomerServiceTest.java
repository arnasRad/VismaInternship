package com.arnasrad.vismainternship.service.revolut.request;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RevolutCustomerServiceTest {

    @InjectMocks
    private RevolutCustomerService revolutCustomerService;

    @Mock
    private RestTemplate restTemplate;

}