package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.model.entity.revolut.account.RevolutAccount;
import com.arnasrad.vismainternship.model.entity.revolut.account.RevolutAccountDetails;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.service.request.AccountService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RevolutAccountService implements AccountService {

    private final RestTemplate restTemplate;
    private final RevolutRequestBuilderService revolutRequestBuilderService;
    @Value("${revolut.endpoint.accounts}")
    private String accountsEndpoint;

    public RevolutAccountService(RestTemplate restTemplate,
                                 RevolutRequestBuilderService revolutRequestBuilderService) {
        this.restTemplate = restTemplate;
        this.revolutRequestBuilderService = revolutRequestBuilderService;
    }

    @Override
    public List<RevolutAccount> getAccounts() {
        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<List<RevolutAccount>> responseEntity = restTemplate.exchange(accountsEndpoint, HttpMethod.GET,
                authorizedHttpEntity, new ParameterizedTypeReference<List<RevolutAccount>>() {
                });

        return responseEntity.getBody();
    }

    @Override
    public RevolutAccount getAccount(String id) {
        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<RevolutAccount> responseEntity = restTemplate.exchange(accountsEndpoint.concat("/").concat(id),
                HttpMethod.GET, authorizedHttpEntity, RevolutAccount.class);

        return responseEntity.getBody();
    }

    @Override
    public List<RevolutAccountDetails> getAccountDetails(String id) {
        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<List<RevolutAccountDetails>> responseEntity = restTemplate.exchange(accountsEndpoint.concat("/")
                        .concat(id).concat("/bank-details"), HttpMethod.GET, authorizedHttpEntity,
                new ParameterizedTypeReference<List<RevolutAccountDetails>>() {
                });

        return responseEntity.getBody();
    }

    public void setAccountsEndpoint(String accountsEndpoint) {
        this.accountsEndpoint = accountsEndpoint;
    }

    @Override
    public String getBankId() {
        return BankId.REVOLUT_ID.getBank();
    }
}
