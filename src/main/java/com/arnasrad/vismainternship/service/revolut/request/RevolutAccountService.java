package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.component.JsonMapper;
import com.arnasrad.vismainternship.model.revolut.account.Account;
import com.arnasrad.vismainternship.model.revolut.account.AccountDetails;
import com.arnasrad.vismainternship.service.ResponseStatusExceptionBuilderService;
import com.arnasrad.vismainternship.service.request.AccountService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class RevolutAccountService implements AccountService {

    @Value("${revolut.endpoint.accounts}")
    private String accountsEndpoint;

    private final RestTemplate restTemplate;
    private final RevolutRequestBuilderService revolutRequestBuilderService;
    private final JsonMapper jsonMapper;
    private final ResponseStatusExceptionBuilderService exceptionBuilder;

    @Autowired
    public RevolutAccountService(RestTemplate restTemplate, RevolutRequestBuilderService revolutRequestBuilderService, JsonMapper jsonMapper, ResponseStatusExceptionBuilderService exceptionBuilder) {

        this.restTemplate = restTemplate;
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.jsonMapper = jsonMapper;
        this.exceptionBuilder = exceptionBuilder;
    }

    @Override
    public List<Account> getAccounts() {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(accountsEndpoint, HttpMethod.GET,
                revolutRequestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> exceptionBuilder.getException400("get-accounts"));

        return jsonMapper.getObjectListFromString(jsonResponse, Account.class);
    }

    @Override
    public Account getAccount(String id) {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(accountsEndpoint.concat("/").concat(id),
                HttpMethod.GET,
                revolutRequestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> exceptionBuilder.getException400("get-account"));

        return jsonMapper.getObjectFromString(jsonResponse, Account.class);
    }

    @Override
    public List<AccountDetails> getAccountDetails(String id) {

        String jsonResponse =
                Optional.ofNullable(restTemplate.exchange(accountsEndpoint.concat("/").concat(id).concat("/bank" +
                                "-details"),
                        HttpMethod.GET,
                        revolutRequestBuilderService.getAuthorizedRequest(), String.class).getBody())
                        .orElseThrow(() -> exceptionBuilder.getException400("get-account-details"));

        return jsonMapper.getObjectListFromString(jsonResponse, AccountDetails.class);
    }
}
