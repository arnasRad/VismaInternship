package com.arnasrad.vismainternship.service.dnb.openbankingapi;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class RefreshJwtTokenServiceTest {

    @Value("${dnb.openbanking.endpoint.access-token}")
    private String tokenEndpoint;

    @InjectMocks
    private RefreshJwtTokenService refreshJwtTokenService;

    @Mock
    private RestTemplate restTemplate;

}