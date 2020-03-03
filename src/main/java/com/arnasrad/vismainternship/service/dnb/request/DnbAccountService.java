package com.arnasrad.vismainternship.service.dnb.request;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.model.dto.account.AccountDetailsDto;
import com.arnasrad.vismainternship.model.dto.account.AccountDto;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.dnb.builder.DnbPsd2RequestBuilderService;
import com.arnasrad.vismainternship.service.request.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DnbAccountService implements AccountService {

    @Value("${dnb.psd2.endpoint.accounts}")
    private String accountsEndpoint;
    private final DnbPsd2RequestBuilderService dnbPsd2RequestBuilderService;
    private final RestTemplate restTemplate;

    public DnbAccountService(DnbPsd2RequestBuilderService dnbPsd2RequestBuilderService, RestTemplate restTemplate) {
        this.dnbPsd2RequestBuilderService = dnbPsd2RequestBuilderService;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<AccountDto> getAccounts() throws NoSuchFunctionalityException {
        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "getAccounts"));
    }

    @Override
    public AccountDto getAccount(String id) throws NoSuchFunctionalityException {
        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "getAccount"));
    }

    @Override
    public List<AccountDetailsDto> getAccountDetails(String id) throws NoSuchFunctionalityException {
        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "getAccountDetails"));
    }

    public String getAccountList() {
        HttpEntity<String> authorizedHttpEntity = dnbPsd2RequestBuilderService.getAuthorizedRequest();

        ResponseEntity<String> responseEntity = restTemplate.exchange(accountsEndpoint, HttpMethod.GET,
                authorizedHttpEntity, String.class);

        return responseEntity.getBody();
    }

    @Override
    public String getBankId() {
        return BankId.DNB_ID.getBank();
    }
}
