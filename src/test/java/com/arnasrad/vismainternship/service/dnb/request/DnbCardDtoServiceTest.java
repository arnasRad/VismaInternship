package com.arnasrad.vismainternship.service.dnb.request;

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
class DnbCardDtoServiceTest {

    private String cardsEndpoint;

    @InjectMocks
    private DnbCardService dnbCardService;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private RevolutRequestBuilderService revolutRequestBuilderService;

    @Mock
    private HttpEntity<String> stringHttpEntityMock;

    @Mock
    private ResponseEntity<String> stringResponseEntityMock;

    @BeforeEach
    void init() {

        MockitoAnnotations.initMocks(DnbCardDtoServiceTest.class);
        this.cardsEndpoint = "https://developer-api-testmode.dnb.no/cards/v0/";
        this.dnbCardService.setCardsEndpoint(cardsEndpoint);
    }

}