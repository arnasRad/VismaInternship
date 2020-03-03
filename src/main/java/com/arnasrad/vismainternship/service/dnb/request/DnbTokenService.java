package com.arnasrad.vismainternship.service.dnb.request;

import com.arnasrad.vismainternship.mapper.TokenMapper;
import com.arnasrad.vismainternship.model.dto.token.DnbTokenDto;
import com.arnasrad.vismainternship.model.entity.token.Token;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.persistence.token.TokenRepository;
import com.arnasrad.vismainternship.service.dnb.builder.DnbRequestBuilderService;
import com.arnasrad.vismainternship.service.request.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DnbTokenService implements TokenService {

    private final RestTemplate restTemplate;
    private final DnbRequestBuilderService dnbRequestBuilderService;
    private final TokenRepository tokenRepository;
    private final TokenMapper tokenMapper;
    @Value("${dnb.openbanking.endpoint.refresh-token}")
    private String refreshTokenEndpoint;
    @Value("${dnb.openbanking.ssn}")
    private String ssn;

    public DnbTokenService(RestTemplate restTemplate, DnbRequestBuilderService dnbRequestBuilderService,
                           TokenRepository tokenRepository, TokenMapper tokenMapper) {
        this.restTemplate = restTemplate;
        this.dnbRequestBuilderService = dnbRequestBuilderService;
        this.tokenRepository = tokenRepository;
        this.tokenMapper = tokenMapper;
    }

    @Override
    public void refresh() {
        HttpEntity<String> httpEntity = dnbRequestBuilderService.getRequest();

        ResponseEntity<DnbTokenDto> responseEntity = restTemplate.exchange(refreshTokenEndpoint, HttpMethod.POST,
                httpEntity, DnbTokenDto.class);

        DnbTokenDto newToken = responseEntity.getBody();
        newToken.setClientId(ssn);
        save(newToken);
    }

    private void save(DnbTokenDto dnbTokenDto) {
        Token token = tokenRepository.findById(dnbTokenDto.getClientId())
                .orElse(new Token());

        token = tokenMapper.mapToTokenEntity(token, dnbTokenDto);
        tokenRepository.save(token);
    }

    public void setRefreshTokenEndpoint(String refreshTokenEndpoint) {
        this.refreshTokenEndpoint = refreshTokenEndpoint;
    }

    @Override
    public String getBankId() {
        return BankId.DNB_ID.getBank();
    }
}
