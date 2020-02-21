package com.arnasrad.vismainternship.service.revolut.request;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

class RevolutCustomerServiceTest {

    @InjectMocks
    private RevolutCustomerService revolutCustomerService;

    @Mock
    private RestTemplate restTemplate;

}