package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.service.mapping.JsonMapperService;
import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.model.revolut.account.RevolutAccount;
import com.arnasrad.vismainternship.model.revolut.account.RevolutAccountDetails;
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
    private final JsonMapperService jsonMapperService;

    @Autowired
    public RevolutAccountService(RestTemplate restTemplate,
                                 RevolutRequestBuilderService revolutRequestBuilderService, JsonMapperService jsonMapperService) {

        this.restTemplate = restTemplate;
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.jsonMapperService = jsonMapperService;
    }

    @Override
    public List<RevolutAccount> getAccounts() throws BadRequestException {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(accountsEndpoint, HttpMethod.GET,
                revolutRequestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> new BadRequestException(String.format(ErrorMessages.BAD_REQUEST, "getAccounts")));

        return jsonMapperService.getObjectListFromString(jsonResponse, RevolutAccount.class);
    }

    @Override
    public RevolutAccount getAccount(String id) throws BadRequestException {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(accountsEndpoint.concat("/").concat(id),
                HttpMethod.GET,
                revolutRequestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> new BadRequestException(String.format(ErrorMessages.BAD_REQUEST, "getAccount")));

        return jsonMapperService.getObjectFromString(jsonResponse, RevolutAccount.class);
    }

    @Override
    public List<RevolutAccountDetails> getAccountDetails(String id) throws BadRequestException {

        String jsonResponse =
                Optional.ofNullable(restTemplate.exchange(accountsEndpoint.concat("/")
                        .concat(id).concat("/bank-details"), HttpMethod.GET,
                        revolutRequestBuilderService.getAuthorizedRequest(), String.class).getBody())
                        .orElseThrow(() -> new BadRequestException(String.format(ErrorMessages.BAD_REQUEST,
                                "getAccountDetails")));

        return jsonMapperService.getObjectListFromString(jsonResponse, RevolutAccountDetails.class);
    }

    @Override
    public String getBankId() {

        return BankId.REVOLUT_ID.getBank();
    }
}
