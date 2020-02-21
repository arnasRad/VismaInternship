package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.model.revolut.account.RevolutAccount;
import com.arnasrad.vismainternship.service.mapping.JsonMapperService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
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
import java.util.Date;
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

        String testAccounts = getTestAccountsString();

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

        String testAccounts = getTestAccountsString();
        List<RevolutAccount> testAccountList = getTestAccounts();

        when(revolutRequestBuilderService.getAuthorizedRequest()).thenReturn(stringHttpEntityMock);

        when(restTemplate.exchange(accountsEndpoint, HttpMethod.GET, stringHttpEntityMock,
                String.class)).thenReturn(stringResponseEntityMock);

        when(stringResponseEntityMock.getBody()).thenReturn(testAccounts);

        when(jsonMapperService.getObjectListFromString(testAccounts, RevolutAccount.class)).thenReturn(testAccountList);

        List<RevolutAccount> expectedAccounts = new ArrayList<>(testAccountList);
        List<RevolutAccount> actualAccounts = revolutAccountService.getAccounts();

        assertThat(actualAccounts, is(expectedAccounts));
    }

    private List<RevolutAccount> getTestAccounts() throws ParseException {

        StdDateFormat formatter = new StdDateFormat().withColonInTimeZone(true);
        List<RevolutAccount> accountList = new ArrayList<>();

        accountList.add(new RevolutAccount("5f47cde3-05fa-44b1-959a-2c60447a3094", "Main", 28577.39, "GBP", "active",
                true, formatter.parse("2020-02-04T09:19:23.465+00:00"), formatter.parse("2020-02-18T06:14:04.640+00:00")));
        accountList.add(new RevolutAccount("65462d79-2613-4f5e-97fd-7c7d1572d4bf", "Business trips", 14700.0, "USD",
                "active", true, formatter.parse("2020-02-04T09:19:23.465+00:00"), formatter.parse("2020-02-04T09:19" +
                ":23.549+00:00")));
        accountList.add(new RevolutAccount("8bed66e7-db72-4096-be39-58460375171a", "Payments", 5300.0, "AUD",
                "active", false, formatter.parse("2020-02-04T09:19:23.540+00:00"), formatter.parse("2020-02-04T09:19:23.540+00:00")));
        accountList.add(new RevolutAccount("14949f04-d50a-437f-ac41-a1cc45bbf721",  "European suppliers", 3445.0,
                "EUR", "active",  true, formatter.parse("2020-02-04T09:19:23.465+00:00"), formatter.parse("2020-02" +
                "-04T09:23:50.927+00:00")));

        return accountList;
    }

    private String getTestAccountsString() {

        return "[\n" +
                "    {\n" +
                "        \"id\": \"5f47cde3-05fa-44b1-959a-2c60447a3094\",\n" +
                "        \"name\": \"Main\",\n" +
                "        \"balance\": 28577.39,\n" +
                "        \"currency\": \"GBP\",\n" +
                "        \"state\": \"active\",\n" +
                "        \"public\": true,\n" +
                "        \"created_at\": \"2020-02-04T09:19:23.465+00:00\",\n" +
                "        \"updated_at\": \"2020-02-18T06:14:04.640+00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": \"65462d79-2613-4f5e-97fd-7c7d1572d4bf\",\n" +
                "        \"name\": \"Business trips\",\n" +
                "        \"balance\": 14700.0,\n" +
                "        \"currency\": \"USD\",\n" +
                "        \"state\": \"active\",\n" +
                "        \"public\": true,\n" +
                "        \"created_at\": \"2020-02-04T09:19:23.465+00:00\",\n" +
                "        \"updated_at\": \"2020-02-04T09:19:23.549+00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": \"8bed66e7-db72-4096-be39-58460375171a\",\n" +
                "        \"name\": \"Payments\",\n" +
                "        \"balance\": 5300.0,\n" +
                "        \"currency\": \"AUD\",\n" +
                "        \"state\": \"active\",\n" +
                "        \"public\": false,\n" +
                "        \"created_at\": \"2020-02-04T09:19:23.540+00:00\",\n" +
                "        \"updated_at\": \"2020-02-04T09:19:23.540+00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": \"14949f04-d50a-437f-ac41-a1cc45bbf721\",\n" +
                "        \"name\": \"European suppliers\",\n" +
                "        \"balance\": 3445.0,\n" +
                "        \"currency\": \"EUR\",\n" +
                "        \"state\": \"active\",\n" +
                "        \"public\": true,\n" +
                "        \"created_at\": \"2020-02-04T09:19:23.465+00:00\",\n" +
                "        \"updated_at\": \"2020-02-04T09:23:50.927+00:00\"\n" +
                "    }\n" +
                "]";
    }
}