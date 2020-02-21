package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.revolut.account.RevolutAccount;
import com.arnasrad.vismainternship.model.revolut.account.RevolutAccountDetails;
import com.arnasrad.vismainternship.service.mapping.JsonMapperService;
import com.arnasrad.vismainternship.service.request.AccountService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private final JsonMapperService jsonMapperService;
    @Value("${revolut.endpoint.accounts}")
    private String accountsEndpoint;

    @Autowired
    public RevolutAccountService(RestTemplate restTemplate,
                                 RevolutRequestBuilderService revolutRequestBuilderService, JsonMapperService jsonMapperService) {

        this.restTemplate = restTemplate;
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.jsonMapperService = jsonMapperService;
    }

    @Override
    public List<RevolutAccount> getAccounts() {

        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<String> responseEntity = restTemplate.exchange(accountsEndpoint, HttpMethod.GET,
                authorizedHttpEntity, String.class);

        String jsonResponse = responseEntity.getBody();

        return jsonMapperService.getObjectListFromString(jsonResponse, RevolutAccount.class);
    }

    @Override
    public RevolutAccount getAccount(String id) {

        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<String> responseEntity = restTemplate.exchange(accountsEndpoint.concat("/").concat(id),
                HttpMethod.GET, authorizedHttpEntity, String.class);

        String jsonResponse = responseEntity.getBody();

        return jsonMapperService.getObjectFromString(jsonResponse, RevolutAccount.class);
    }

    @Override
    public List<RevolutAccountDetails> getAccountDetails(String id) {

        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<String> responseEntity = restTemplate.exchange(accountsEndpoint.concat("/")
                .concat(id).concat("/bank-details"), HttpMethod.GET, authorizedHttpEntity, String.class);

        String jsonResponse = responseEntity.getBody();

        return jsonMapperService.getObjectListFromString(jsonResponse, RevolutAccountDetails.class);
    }

    public void setAccountsEndpoint(String accountsEndpoint) {

        this.accountsEndpoint = accountsEndpoint;
    }

    @Override
    public String getBankId() {

        return BankId.REVOLUT_ID.getBank();
    }
}
