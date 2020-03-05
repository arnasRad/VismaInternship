package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.mapper.revolut.RevolutAccountMapper;
import com.arnasrad.vismainternship.model.dto.AccountDto;
import com.arnasrad.vismainternship.model.dto.revolut.account.RevolutAccountDetailsDto;
import com.arnasrad.vismainternship.model.dto.revolut.account.RevolutAccountDto;
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
    private final RevolutAccountMapper revolutAccountMapper;
    @Value("${revolut.endpoint.accounts}")
    private String accountsEndpoint;

    public RevolutAccountService(RestTemplate restTemplate, RevolutRequestBuilderService revolutRequestBuilderService, RevolutAccountMapper revolutAccountMapper) {
        this.restTemplate = restTemplate;
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.revolutAccountMapper = revolutAccountMapper;
    }

    @Override
    public List<AccountDto> getAccounts() {
        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<List<RevolutAccountDto>> responseEntity = restTemplate.exchange(accountsEndpoint, HttpMethod.GET,
                authorizedHttpEntity, new ParameterizedTypeReference<List<RevolutAccountDto>>() {
                });

        List<RevolutAccountDto> revolutAccountDtoList = responseEntity.getBody();
        return revolutAccountMapper.mapToAccountDtoList(revolutAccountDtoList);
    }

    @Override
    public AccountDto getAccount(String id) {
        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<RevolutAccountDto> responseEntity = restTemplate.exchange(accountsEndpoint.concat("/").concat(id),
                HttpMethod.GET, authorizedHttpEntity, RevolutAccountDto.class);

        RevolutAccountDto revolutAccountDto = responseEntity.getBody();
        return revolutAccountMapper.mapToAccountDto(revolutAccountDto);
    }

    public List<RevolutAccountDetailsDto> getAccountDetails(String id) {
        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<List<RevolutAccountDetailsDto>> responseEntity =
                restTemplate.exchange(accountsEndpoint.concat("/").concat(id).concat("/bank-details"),
                        HttpMethod.GET, authorizedHttpEntity,
                        new ParameterizedTypeReference<List<RevolutAccountDetailsDto>>() {});

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
