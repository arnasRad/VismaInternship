package com.arnasrad.vismainternship.service.revolut.builder.unit;

import com.arnasrad.vismainternship.service.revolut.builder.RevolutHeaderBuilderService;
import com.arnasrad.vismainternship.service.revolut.request.RevolutTokenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RevolutHeaderBuilderServiceTest {

    @Mock
    RevolutTokenService revolutTokenService;
    @InjectMocks
    private RevolutHeaderBuilderService revolutHeaderBuilderService;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(RevolutHeaderBuilderServiceTest.class);
        revolutHeaderBuilderService.setHeaderName("test");
        revolutHeaderBuilderService.setHeaderType("test");
    }

//    @Test
//    public void whenGetAuthorizedHeadersCalled_thenReturnHttpHeadersWithTwoHeaders() {
//        when(revolutTokenService.get()).thenReturn("test_token");
//
//        HttpHeaders headers = revolutHeaderBuilderService.getAuthorizedHeaders();
//
//        assertEquals(2, headers.entrySet().size());
//    }
}
