package com.arnasrad.vismainternship.revolut.service;

import com.arnasrad.vismainternship.revolut.component.JsonResponseMapper;
import com.arnasrad.vismainternship.revolut.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service("revolut-request-service")
public class RequestService {

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

    public List<Account> getAccounts() {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(accountsEndpoint, HttpMethod.GET,
                requestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad accounts request"));

        return jsonResponseMapper.getAccountList(jsonResponse);
    }
}
