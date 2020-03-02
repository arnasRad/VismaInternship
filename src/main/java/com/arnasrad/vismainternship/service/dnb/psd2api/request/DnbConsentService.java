package com.arnasrad.vismainternship.service.dnb.psd2api.request;

import com.arnasrad.vismainternship.mapper.TokenMapper;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.persistence.token.TokenRepository;
import com.arnasrad.vismainternship.service.dnb.openbankingapi.builder.DnbRequestBuilderService;
import com.arnasrad.vismainternship.service.request.TokenService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DnbConsentService implements TokenService {

    private final RestTemplate restTemplate;
    private final DnbRequestBuilderService dnbRequestBuilderService;
    private final TokenRepository tokenRepository;
    private final TokenMapper tokenMapper;

    public DnbConsentService(RestTemplate restTemplate, DnbRequestBuilderService dnbRequestBuilderService,
                             TokenRepository tokenRepository, TokenMapper tokenMapper) {
        this.restTemplate = restTemplate;
        this.dnbRequestBuilderService = dnbRequestBuilderService;
        this.tokenRepository = tokenRepository;
        this.tokenMapper = tokenMapper;
    }

    @Override
    public void refresh() {

    }

    private void save() {

    }

    @Override
    public String getBankId() {
        return BankId.DNB_ID.getBank();
    }
}
