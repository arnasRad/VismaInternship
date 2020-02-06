package com.arnasrad.SpringBootDemo1.revolut;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping
public class AccountController {

    RestTemplate restTemplate = new RestTemplate();
    final String revolutUrl = "https://sandbox-b2b.revolut.com/api/1.0";

    @Value("${accessToken.constant}")
    private String accessToken;

    @GetMapping("/")
    String mainPage() {
        return "Revolut Open Banking API!";
    }

    @GetMapping("/revolut")
    List<Account> getAccounts() throws JsonProcessingException {
        HttpHeaders httpHeaders = new HttpHeaders();
        // TODO: implement refresh token
        httpHeaders.setBearerAuth(accessToken);

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, Account.class);

        String jsonResponse = restTemplate.exchange(revolutUrl + "/accounts", HttpMethod.GET, httpEntity, String.class).getBody();
        if (jsonResponse != null)
            return mapper.readValue(jsonResponse, type);
        else
            return null;
    }
}
