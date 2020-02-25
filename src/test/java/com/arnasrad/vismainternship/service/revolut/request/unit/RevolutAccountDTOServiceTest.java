package com.arnasrad.vismainternship.service.revolut.request.unit;

import com.arnasrad.vismainternship.model.entity.revolut.account.RevolutAccount;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import com.arnasrad.vismainternship.service.revolut.request.RevolutAccountService;
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
class RevolutAccountDTOServiceTest {

    private String accountsEndpoint;

    @InjectMocks
    private RevolutAccountService revolutAccountService;

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

        MockitoAnnotations.initMocks(RevolutAccountDTOServiceTest.class);
        this.accountsEndpoint = "https://sandbox-b2b.revolut.com/api/1.0/accounts";
        this.revolutAccountService.setAccountsEndpoint(accountsEndpoint);
    }

    @Test
    public void whenAllMethodsExecutesOnce_thenGetAccountsReturnsListOfAccounts() {

        String testAccounts = RevolutStringTestData.getAccountsString();

        when(revolutRequestBuilderService.getAuthorizedRequest()).thenReturn(stringHttpEntityMock);

        when(restTemplate.exchange(accountsEndpoint, HttpMethod.GET, stringHttpEntityMock,
                String.class)).thenReturn(stringResponseEntityMock);

        when(stringResponseEntityMock.getBody()).thenReturn(testAccounts);

        List<RevolutAccount> actualAccounts = revolutAccountService.getAccounts();

        verify(revolutRequestBuilderService, times(1)).getAuthorizedRequest();
        verify(restTemplate, times(1)).exchange(accountsEndpoint, HttpMethod.GET, stringHttpEntityMock,
                String.class);
        verify(stringResponseEntityMock, times(1)).getBody();

        assertNotEquals(0, actualAccounts.size());
    }

    @Test
    public void whenResponseReturnsAccountListJsonString_thenGetAccountsReturnsListOfAccounts() {

        String testAccounts = RevolutStringTestData.getAccountsString();
        List<RevolutAccount> testAccountList = RevolutObjectTestData.getTestAccounts();

        when(revolutRequestBuilderService.getAuthorizedRequest()).thenReturn(stringHttpEntityMock);

        when(restTemplate.exchange(accountsEndpoint, HttpMethod.GET, stringHttpEntityMock,
                String.class)).thenReturn(stringResponseEntityMock);

        when(stringResponseEntityMock.getBody()).thenReturn(testAccounts);

        List<RevolutAccount> expectedAccounts = new ArrayList<>(testAccountList);
        List<RevolutAccount> actualAccounts = revolutAccountService.getAccounts();

        assertThat(actualAccounts, is(expectedAccounts));
    }
}