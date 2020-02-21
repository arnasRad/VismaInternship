package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import com.arnasrad.vismainternship.service.mapping.JsonMapperService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class DNBCustomerServiceTest {

    private String customersEndpoint;
    private String customerInfoEndpoint;
    private String currentCustomerInfoEndpoint;

    @InjectMocks
    private DNBCustomerService dnbCustomerService;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private RevolutRequestBuilderService revolutRequestBuilderService;

    @Mock
    private JsonMapperService jsonMapperService;

    @Mock
    private HttpEntity<String> stringHttpEntityMock;

    @Mock
    private ResponseEntity<String> stringResponseEntityMock;

    @BeforeEach
    void init() {

        MockitoAnnotations.initMocks(DNBCustomerServiceTest.class);
        this.customersEndpoint = "https://developer-api-testmode.dnb.no/test-customers/v0";
        this.customerInfoEndpoint = "https://developer-api-testmode.dnb.no/customers/v0/current";
        this.currentCustomerInfoEndpoint = "https://developer-api-testmode.dnb.no/customers/v0/";
        this.dnbCustomerService.setCustomersEndpoint(customersEndpoint);
        this.dnbCustomerService.setCustomerInfoEndpoint(customerInfoEndpoint);
        this.dnbCustomerService.setCurrentCustomerInfoEndpoint(currentCustomerInfoEndpoint);
    }

}