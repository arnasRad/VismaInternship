package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.service.mapping.JsonMapperService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RevolutCardServiceTest {

    @InjectMocks
    private RevolutCardService revolutCardService;

    @Mock
    private RestTemplate restTemplate;

}