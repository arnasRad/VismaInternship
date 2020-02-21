package com.arnasrad.vismainternship.service.revolut.request;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

class RevolutTransferServiceTest {

    @Value("${revolut.endpoint.transfer}")
    private String transferEndpoint;

    @InjectMocks
    private RevolutTransferService revolutTransferService;

    @Mock
    private RestTemplate restTemplate;

}