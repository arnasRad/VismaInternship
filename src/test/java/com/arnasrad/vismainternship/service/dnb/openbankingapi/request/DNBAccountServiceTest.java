package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class DNBAccountServiceTest {

    @InjectMocks
    private DNBAccountService dnbAccountService;

    @Mock
    private RestTemplate restTemplate;

}