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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping
public class AccountController {
    @Value("${revolut.sandbox.constant.accessToken}")
    private String accessToken;

    @Value("${url.revolut.accounts}")
    private String accountsUrl;

    @Autowired
    RefreshTokenService refreshTokenService;

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    String mainPage() {
        return "Revolut Open Banking API!";
    }

    @GetMapping("/revolut")
    List<Account> getAccounts() {
        HttpHeaders httpHeaders = new HttpHeaders();
        // TODO: implement refresh token
        httpHeaders.setBearerAuth(accessToken);
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        try {
            String jsonResponse = restTemplate.exchange(accountsUrl, HttpMethod.GET, httpEntity, String.class).getBody();
            if (jsonResponse != null)
                return Utils.getAccountListFromJsonString(jsonResponse);
            else
                return null;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Autowired
    JwtTokenService jwtTokenService;
    @Autowired
    KeyLoadService keyLoadService;
    @GetMapping("/refresh-token")
    String getJwtToken() {
        try {
            String result = refreshTokenService.refreshToken();
            return result;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
        //return jwtTokenService.generateToken();
    }
}
