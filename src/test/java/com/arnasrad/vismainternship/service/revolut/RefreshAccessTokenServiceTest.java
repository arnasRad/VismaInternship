package com.arnasrad.vismainternship.service.revolut;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

class RefreshAccessTokenServiceTest {

    @Value("${revolut.endpoint.access-token}")
    private String tokenEndpoint;

    @InjectMocks
    private RefreshAccessTokenService refreshAccessTokenService;

    @Mock
    private RestTemplate restTemplate;

}