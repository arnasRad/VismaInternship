package com.arnasrad.vismainternship.revolut.controller;

import com.arnasrad.vismainternship.revolut.component.JsonAccountMapper;
import com.arnasrad.vismainternship.revolut.model.Account;
import com.arnasrad.vismainternship.revolut.service.RefreshTokenService;
import com.arnasrad.vismainternship.revolut.service.RequestBuilderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping
public class AccountController {

    @Value("${url.revolut.accounts}")
    private String accountsUrl;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RequestBuilderService requestBuilderService;

    @Autowired
    private JsonAccountMapper jsonAccountMapper;

    @GetMapping("/")
    public String mainPage() {
        return "Revolut Open Banking API!";
    }

    @GetMapping("/revolut")
    public List<Account> getAccounts() {

        HttpEntity<String> httpEntity = requestBuilderService.getAuthorizedHttpEntity();
        try {
            String jsonResponse = restTemplate.exchange(accountsUrl, HttpMethod.GET, httpEntity, String.class).getBody();
            if (jsonResponse != null)
                return jsonAccountMapper.getAccountList(jsonResponse);
            else
                return null; // TODO: return Optional
        } catch (JsonProcessingException e) { // TODO: use logger
            e.printStackTrace();
            return null; // TODO: return Optional
        }
    }
}
