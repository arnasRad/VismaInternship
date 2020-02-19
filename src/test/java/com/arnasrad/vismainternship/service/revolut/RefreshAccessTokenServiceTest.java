package com.arnasrad.vismainternship.service.revolut;

import com.arnasrad.vismainternship.service.revolut.request.RevolutAccountService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RefreshAccessTokenServiceTest {

    @Value("${revolut.endpoint.access-token}")
    private String tokenEndpoint;

    @InjectMocks
    private RefreshAccessTokenService refreshAccessTokenService;

    @Mock
    private RestTemplate restTemplate;

}