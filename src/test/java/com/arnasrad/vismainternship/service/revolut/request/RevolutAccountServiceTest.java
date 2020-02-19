package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.model.revolut.account.RevolutAccount;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.arnasrad.vismainternship.service.mapping.JsonMapperService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
class RevolutAccountServiceTest {

    @Value("${revolut.endpoint.accounts}")
    private String accountsEndpoint;

    private final JsonMapperService jsonMapperService;

    @Autowired
    public RevolutAccountServiceTest(JsonMapperService jsonMapperService) {
        this.jsonMapperService = jsonMapperService;
    }

    @InjectMocks
    private RevolutAccountService revolutAccountService;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    Date date;

    @BeforeAll
    static void setup() {
        MockitoAnnotations.initMocks(RevolutAccountServiceTest.class);
    }

    @Test
    public void whenResponseReturnsAccountListJsonString_thengetAccountsReturnsListOfAccounts() throws BadRequestException {

        String testAccounts = getTestAccountsString();

//        when(restTemplate.exchange(
//                eq(accountsEndpoint),
//                eq(HttpMethod.GET), any(HttpEntity.class), eq(String.class)).getBody()).thenReturn(testAccounts);

        when(restTemplate.exchange(
                accountsEndpoint,
                HttpMethod.GET, mock(HttpEntity.class), String.class).getBody()).thenReturn(testAccounts);

        List<RevolutAccount> expectedAccounts = getTestAccounts();
        List<RevolutAccount> actualAccounts = revolutAccountService.getAccounts();

        assertEquals(expectedAccounts, actualAccounts);
    }

//    private List<RevolutAccount> getTestAccounts() {
//
//        List<RevolutAccount> accountList = new ArrayList<>();
//
//        for(int i = 0; i < 10; ++i) {
//
//            accountList.add(mock(RevolutAccount.class));
////            accountList.add(new RevolutAccount(anyString(), anyString(), anyDouble(), anyString(),
////                    anyString(), anyBoolean(), any(Date.class), any(Date.class)));
//        }
//
//        return accountList;
//    }

    private List<RevolutAccount> getTestAccounts() {

        return jsonMapperService.getObjectListFromString(getTestAccountsString(), RevolutAccount.class);
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

//    private class RestTemplateExchangeMatcher implements ArgumentMatcher<>
}