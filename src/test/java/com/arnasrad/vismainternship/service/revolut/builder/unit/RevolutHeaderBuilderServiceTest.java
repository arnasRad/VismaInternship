package com.arnasrad.vismainternship.service.revolut.builder.unit;

import com.arnasrad.vismainternship.service.revolut.builder.RevolutHeaderBuilderService;
import com.arnasrad.vismainternship.token.RevolutAccessToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RevolutHeaderBuilderServiceTest {

    @Mock
    RevolutAccessToken revolutAccessToken;
    @InjectMocks
    private RevolutHeaderBuilderService revolutHeaderBuilderService;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(RevolutHeaderBuilderServiceTest.class);
        revolutHeaderBuilderService.setHeaderName("test");
        revolutHeaderBuilderService.setHeaderType("test");
    }

    @Test
    public void whenGetAuthorizedHeadersCalled_thenReturnHttpHeadersWithTwoHeaders() {
        when(revolutAccessToken.getToken()).thenReturn("test_token");

        HttpHeaders headers = revolutHeaderBuilderService.getAuthorizedHeaders();

        assertEquals(2, headers.entrySet().size());
    }
}
