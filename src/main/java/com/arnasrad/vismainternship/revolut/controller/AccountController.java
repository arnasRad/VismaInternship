package com.arnasrad.vismainternship.revolut.controller;

import com.arnasrad.vismainternship.revolut.component.JsonResponseMapper;
import com.arnasrad.vismainternship.revolut.model.Account;
import com.arnasrad.vismainternship.revolut.service.RefreshTokenService;
import com.arnasrad.vismainternship.revolut.service.RequestBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class AccountController {

    @Value("${revolut.endpoint.accounts}")
    private String accountsEndpoint;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("revolut-request-builder")
    private RequestBuilderService requestBuilderService;

    @Autowired
    @Qualifier("revolut-json-revolut-mapper")
    private JsonResponseMapper jsonResponseMapper;

    @GetMapping("/")
    public String mainPage() {
        return "Welcome to Visma Open Banking API!";
    }

    @GetMapping("/revolut/accounts")
    public List<Account> getAccounts() {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(accountsEndpoint, HttpMethod.GET,
                requestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad accounts request"));

        return jsonResponseMapper.getAccountList(jsonResponse);
    }
}
