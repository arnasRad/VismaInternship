package com.arnasrad.vismainternship.service.revolut.request.unit;

import com.arnasrad.vismainternship.model.revolut.counterparty.RevolutCounterparty;
import com.arnasrad.vismainternship.model.revolut.requestbody.CounterpartyRequestBody;
import com.arnasrad.vismainternship.service.mapping.JsonMapperService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import com.arnasrad.vismainternship.service.revolut.request.RevolutCounterpartyService;
import com.arnasrad.vismainternship.service.revolut.testdata.RevolutObjectTestData;
import com.arnasrad.vismainternship.service.revolut.testdata.RevolutStringTestData;
import org.json.JSONException;
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
import java.util.Arrays;
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
    private JsonMapperService jsonMapperService;

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

        when(revolutRequestBuilderService.getCounterpartiesRequest()).thenReturn(stringHttpEntityMock);

        when(restTemplate.exchange(counterpartiesEndpoint, HttpMethod.GET, stringHttpEntityMock,
                String.class)).thenReturn(stringResponseEntityMock);

        when(stringResponseEntityMock.getBody()).thenReturn(testCounterpartiesString);

        when(jsonMapperService.getObjectListFromString(testCounterpartiesString, RevolutCounterparty.class))
                .thenReturn(Arrays.asList(mock(RevolutCounterparty.class), mock(RevolutCounterparty.class)));

        List<RevolutCounterparty> actualCounterparties = revolutCounterpartyService.getCounterparties();

        verify(revolutRequestBuilderService, times(1)).getCounterpartiesRequest();
        verify(restTemplate, times(1)).exchange(counterpartiesEndpoint, HttpMethod.GET, stringHttpEntityMock,
                String.class);
        verify(stringResponseEntityMock, times(1)).getBody();
        verify(jsonMapperService, times(1)).getObjectListFromString(testCounterpartiesString, RevolutCounterparty.class);

        assertNotEquals(0, actualCounterparties.size());
    }

    @Test
    public void whenResponseReturnsCounterpartyListJsonString_thenGetCounterpartiesReturnsListOfCounterparties() {

        String testCounterpartiesString = RevolutStringTestData.getCounterpartyListString();
        List<RevolutCounterparty> testCounterpartyList = RevolutObjectTestData.getTestCounterpartyList();

        when(revolutRequestBuilderService.getCounterpartiesRequest()).thenReturn(stringHttpEntityMock);

        when(restTemplate.exchange(counterpartiesEndpoint, HttpMethod.GET, stringHttpEntityMock,
                String.class)).thenReturn(stringResponseEntityMock);

        when(stringResponseEntityMock.getBody()).thenReturn(testCounterpartiesString);

        when(jsonMapperService.getObjectListFromString(testCounterpartiesString, RevolutCounterparty.class)).thenReturn(testCounterpartyList);

        List<RevolutCounterparty> expectedCounterparties = new ArrayList<>(testCounterpartyList);
        List<RevolutCounterparty> actualCounterparties = revolutCounterpartyService.getCounterparties();

        assertThat(actualCounterparties, is(expectedCounterparties));
    }

    @Test
    public void whenResponseReturnsCounterparty_thenAddCounterpartyReturnsAddedCounterparty() throws JSONException {

        CounterpartyRequestBody requestBody = RevolutObjectTestData.getTestCounterpartyRequestBody();
        String testCounterpartyString = RevolutStringTestData.getCounterpartyString();
        RevolutCounterparty testCounterparty = RevolutObjectTestData.getTestCounterparty();

        when(revolutRequestBuilderService.getCounterpartyRequest(requestBody)).thenReturn(stringHttpEntityMock);

        when(restTemplate.postForEntity(counterpartyEndpoint, stringHttpEntityMock, String.class)).thenReturn(stringResponseEntityMock);

        when(stringResponseEntityMock.getBody()).thenReturn(testCounterpartyString);

        when(jsonMapperService.getObjectFromString(testCounterpartyString, RevolutCounterparty.class)).thenReturn(testCounterparty);

        RevolutCounterparty actualCounterparty = revolutCounterpartyService.addCounterparty(requestBody);

        assertThat(actualCounterparty, is(testCounterparty));
    }
}