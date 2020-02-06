package com.arnasrad.SpringBootDemo1.revolut.controller;

import com.arnasrad.SpringBootDemo1.revolut.model.Account;
import com.arnasrad.SpringBootDemo1.revolut.util.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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

    @Value("${revolut.sandbox.accessToken.constant}")
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
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("", "");

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        String jsonResponse = restTemplate.exchange(revolutUrl + "/accounts", HttpMethod.GET, httpEntity, String.class).getBody();
        if (jsonResponse != null)
            return Utils.getAccountListFromJsonString(jsonResponse);
        else
            return null;
    }
}
