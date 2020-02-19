package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import com.arnasrad.vismainternship.service.revolut.request.RevolutAccountService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DNBAccountServiceTest {

    @InjectMocks
    private DNBAccountService dnbAccountService;

    @Mock
    private RestTemplate restTemplate;

}