package com.arnasrad.vismainternship.service.revolut.request.unit;

import com.arnasrad.vismainternship.model.dto.revolut.counterparty.RevolutCounterpartyDTO;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import com.arnasrad.vismainternship.service.revolut.request.RevolutCounterpartyService;
import com.arnasrad.vismainternship.service.revolut.testdata.RevolutObjectTestData;
import com.arnasrad.vismainternship.service.revolut.testdata.RevolutStringTestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class RevolutCounterpartyServiceTest {
    private String counterpartyEndpoint;
    private String counterpartiesEndpoint;

    @InjectMocks
    private RevolutCounterpartyService revolutCounterpartyService;

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
        MockitoAnnotations.initMocks(RevolutCounterpartyServiceTest.class);
        this.counterpartyEndpoint = "https://sandbox-b2b.revolut.com/api/1.0/counterparty";
        this.counterpartiesEndpoint = "https://sandbox-b2b.revolut.com/api/1.0/counterparties";
        this.revolutCounterpartyService.setCounterpartyEndpoint(counterpartyEndpoint);
        this.revolutCounterpartyService.setCounterpartiesEndpoint(counterpartiesEndpoint);
    }

    @Test
    public void whenAllMethodsExecutesOnce_thenGetCounterpartiesReturnsListOfCounterparties() {
        String testCounterpartiesString = RevolutStringTestData.getCounterpartyListString();

        when(restTemplate.exchange(counterpartiesEndpoint, HttpMethod.GET, stringHttpEntityMock,
                String.class)).thenReturn(stringResponseEntityMock);

        when(stringResponseEntityMock.getBody()).thenReturn(testCounterpartiesString);

        List<RevolutCounterpartyDTO> actualCounterparties = revolutCounterpartyService.getCounterparties();

        verify(restTemplate, times(1)).exchange(counterpartiesEndpoint, HttpMethod.GET, stringHttpEntityMock,
                String.class);
        verify(stringResponseEntityMock, times(1)).getBody();

        assertNotEquals(0, actualCounterparties.size());
    }

    @Test
    public void whenResponseReturnsCounterpartyListJsonString_thenGetCounterpartiesReturnsListOfCounterparties() {
        String testCounterpartiesString = RevolutStringTestData.getCounterpartyListString();
        List<RevolutCounterpartyDTO> testCounterpartyList = RevolutObjectTestData.getTestCounterpartyList();

        when(restTemplate.exchange(counterpartiesEndpoint, HttpMethod.GET, stringHttpEntityMock,
                String.class)).thenReturn(stringResponseEntityMock);

        when(stringResponseEntityMock.getBody()).thenReturn(testCounterpartiesString);

        List<RevolutCounterpartyDTO> expectedCounterparties = new ArrayList<>(testCounterpartyList);
        List<RevolutCounterpartyDTO> actualCounterparties = revolutCounterpartyService.getCounterparties();

        assertThat(actualCounterparties, is(expectedCounterparties));
    }

    @Test
    public void whenResponseReturnsCounterparty_thenAddCounterpartyReturnsAddedCounterparty() {
//        String testCounterpartyString = RevolutStringTestData.getCounterpartyString();
//        RevolutCounterparty testCounterparty = RevolutObjectTestData.getTestCounterparty();
//
//        when(revolutRequestBuilderService.getAuthorizedJsonRequestWithBody(requestBody)).thenReturn(stringHttpEntityMock);
//
//        when(restTemplate.postForEntity(counterpartyEndpoint, stringHttpEntityMock, String.class)).thenReturn(stringResponseEntityMock);
//
//        when(stringResponseEntityMock.getBody()).thenReturn(testCounterpartyString);
//
//        RevolutCounterparty actualCounterparty = revolutCounterpartyService.addCounterparty(requestBody);
//
//        assertThat(actualCounterparty, is(testCounterparty));
    }
}