package com.arnasrad.SpringBootDemo1.revolut.controller;

import com.arnasrad.SpringBootDemo1.revolut.model.Account;
import com.arnasrad.SpringBootDemo1.revolut.service.JwtTokenService;
import com.arnasrad.SpringBootDemo1.revolut.service.KeyLoadService;
import com.arnasrad.SpringBootDemo1.revolut.service.RefreshTokenService;
import com.arnasrad.SpringBootDemo1.revolut.util.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
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

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping
public class AccountController {
    @Value("${revolut.sandbox.constant.accessToken}")
    private String accessToken;

    @Autowired
    RefreshTokenService refreshTokenService;

    RestTemplate restTemplate = new RestTemplate();
    final String revolutUrl = "https://sandbox-b2b.revolut.com/api/1.0";

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

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        String jsonResponse = restTemplate.exchange(revolutUrl + "/accounts", HttpMethod.GET, httpEntity, String.class).getBody();
        if (jsonResponse != null)
            return Utils.getAccountListFromJsonString(jsonResponse);
        else
            return null;
    }

    @Autowired
    JwtTokenService jwtTokenService;
    @Autowired
    KeyLoadService keyLoadService;
    @GetMapping("/test-token")
    String getJwtToken() {
        return jwtTokenService.generateToken();
        //return jwtTokenService.generateToken();
    }
}
