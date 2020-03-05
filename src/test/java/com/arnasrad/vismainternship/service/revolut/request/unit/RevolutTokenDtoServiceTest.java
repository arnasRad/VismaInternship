package com.arnasrad.vismainternship.service.revolut.request.unit;

import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import com.arnasrad.vismainternship.service.revolut.request.RevolutTokenService;
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
class RevolutTokenDtoServiceTest {

    private String tokenEndpoint;

    @InjectMocks
    private RevolutTokenService revolutTokenService;

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
        MockitoAnnotations.initMocks(RevolutTokenDtoServiceTest.class);
        this.tokenEndpoint = "https://sandbox-b2b.revolut.com/api/1.0/auth/token";
        this.revolutTokenService.setRefreshTokenEndpoint(tokenEndpoint);
    }

}