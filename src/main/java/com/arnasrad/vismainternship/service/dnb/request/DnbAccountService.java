package com.arnasrad.vismainternship.service.dnb.request;

import com.arnasrad.vismainternship.mapper.dnb.DnbAccountMapper;
import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.model.dto.AccountDto;
import com.arnasrad.vismainternship.model.dto.dnb.account.DnbAccountDto;
import com.arnasrad.vismainternship.model.dto.dnb.account.DnbAccountDtoWrapper;
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
    private final DnbAccountMapper dnbAccountMapper;

    public DnbAccountService(DnbPsd2RequestBuilderService dnbPsd2RequestBuilderService, RestTemplate restTemplate,
                             DnbAccountMapper dnbAccountMapper) {
        this.dnbPsd2RequestBuilderService = dnbPsd2RequestBuilderService;
        this.restTemplate = restTemplate;
        this.dnbAccountMapper = dnbAccountMapper;
    }

    @Override
    public List<AccountDto> getAccounts() throws NoSuchFunctionalityException {
        HttpEntity<String> authorizedHttpEntity = dnbPsd2RequestBuilderService.getAuthorizedRequest();

        ResponseEntity<DnbAccountDtoWrapper> responseEntity = restTemplate.exchange(accountsEndpoint, HttpMethod.GET,
                authorizedHttpEntity, DnbAccountDtoWrapper.class);

        DnbAccountDtoWrapper accountsWrapper = responseEntity.getBody();
        List<DnbAccountDto> dnbAccountDtoList = accountsWrapper.getAccounts();

        return dnbAccountMapper.mapToAccountDtoList(dnbAccountDtoList);
    }

    @Override
    public AccountDto getAccount(String iban) throws NoSuchFunctionalityException {
        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "getAccount"));
    }

    public DnbAccountDtoWrapper getAccountList() {
        HttpEntity<String> authorizedHttpEntity = dnbPsd2RequestBuilderService.getAuthorizedRequest();

        ResponseEntity<DnbAccountDtoWrapper> responseEntity = restTemplate.exchange(accountsEndpoint, HttpMethod.GET,
                authorizedHttpEntity, DnbAccountDtoWrapper.class);

        return responseEntity.getBody();
    }

    @Override
    public String getBankId() {
        return BankId.DNB_ID.getBank();
    }
}
