package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.model.revolut.account.RevolutAccount;
import com.arnasrad.vismainternship.service.mapping.JsonMapperService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import com.arnasrad.vismainternship.service.revolut.testdata.RevolutTestData;
import com.fasterxml.jackson.databind.util.StdDateFormat;
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

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RevolutAccountServiceTest {

    private String accountsEndpoint;

    @InjectMocks
    private RevolutAccountService revolutAccountService;

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

        MockitoAnnotations.initMocks(RevolutAccountServiceTest.class);
        this.accountsEndpoint = "https://sandbox-b2b.revolut.com/api/1.0/accounts";
        this.revolutAccountService.setAccountsEndpoint(accountsEndpoint);
    }

    @Test
    public void whenAllMethodsExecutesOnce_thenGetAccountsReturnsListOfAccounts()
            {

        String testAccounts = RevolutTestData.getTestAccountsString();

        when(revolutRequestBuilderService.getAuthorizedRequest()).thenReturn(stringHttpEntityMock);

        when(restTemplate.exchange(accountsEndpoint, HttpMethod.GET, stringHttpEntityMock,
                String.class)).thenReturn(stringResponseEntityMock);

        when(stringResponseEntityMock.getBody()).thenReturn(testAccounts);

        when(jsonMapperService.getObjectListFromString(testAccounts, RevolutAccount.class))
                .thenReturn(Arrays.asList(mock(RevolutAccount.class), mock(RevolutAccount.class)));

        List<RevolutAccount> actualAccounts = revolutAccountService.getAccounts();

        verify(revolutRequestBuilderService, times(1)).getAuthorizedRequest();
        verify(restTemplate, times(1)).exchange(accountsEndpoint, HttpMethod.GET, stringHttpEntityMock,
                String.class);
        verify(stringResponseEntityMock, times(1)).getBody();
        verify(jsonMapperService, times(1)).getObjectListFromString(testAccounts, RevolutAccount.class);

        assertNotEquals(0, actualAccounts.size());
    }

    @Test
    public void whenResponseReturnsAccountListJsonString_thenGetAccountsReturnsListOfAccounts() throws ParseException {

        String testAccounts = RevolutTestData.getTestAccountsString();
        List<RevolutAccount> testAccountList = RevolutTestData.getTestAccounts();

        when(revolutRequestBuilderService.getAuthorizedRequest()).thenReturn(stringHttpEntityMock);

        when(restTemplate.exchange(accountsEndpoint, HttpMethod.GET, stringHttpEntityMock,
                String.class)).thenReturn(stringResponseEntityMock);

        when(stringResponseEntityMock.getBody()).thenReturn(testAccounts);

        when(jsonMapperService.getObjectListFromString(testAccounts, RevolutAccount.class)).thenReturn(testAccountList);

        List<RevolutAccount> expectedAccounts = new ArrayList<>(testAccountList);
        List<RevolutAccount> actualAccounts = revolutAccountService.getAccounts();

        assertThat(actualAccounts, is(expectedAccounts));
    }
}