package com.arnasrad.vismainternship.service.revolut.request;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

class RevolutCardServiceTest {

    @InjectMocks
    private RevolutCardService revolutCardService;

    @Mock
    private RestTemplate restTemplate;

}