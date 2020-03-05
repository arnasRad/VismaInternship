package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.mapper.TokenMapper;
import com.arnasrad.vismainternship.model.dto.revolut.token.RevolutTokenDto;
import com.arnasrad.vismainternship.model.entity.token.Token;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.persistence.token.TokenRepository;
import com.arnasrad.vismainternship.service.request.TokenService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class RevolutTokenService implements TokenService {
    private final RevolutRequestBuilderService revolutRequestBuilderService;
    private final RestTemplate restTemplate;
    private final TokenRepository tokenRepository;
    private final TokenMapper tokenMapper;
    @Value("${revolut.endpoint.refresh-token}")
    private String refreshTokenEndpoint;
    @Value("${revolut.sandbox.constant.clientId}")
    private String clientId;

    public RevolutTokenService(RevolutRequestBuilderService revolutRequestBuilderService,
                               RestTemplate restTemplate, TokenRepository tokenRepository,
                               TokenMapper tokenMapper) {
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.restTemplate = restTemplate;
        this.tokenRepository = tokenRepository;
        this.tokenMapper = tokenMapper;
    }

    @Override
    public void refresh() {
        HttpEntity<MultiValueMap<String, String>> httpEntity = revolutRequestBuilderService.getTokenRequest();

        ResponseEntity<RevolutTokenDto> responseEntity = restTemplate.exchange(refreshTokenEndpoint, HttpMethod.POST,
                httpEntity, RevolutTokenDto.class);

        RevolutTokenDto newToken = responseEntity.getBody();
        newToken.setClientId(clientId);
        save(newToken);
    }

    private void save(RevolutTokenDto revolutToken) {
        Token token = tokenRepository.findById(revolutToken.getClientId())
                .orElse(new Token());

        token = tokenMapper.mapToTokenEntity(token, revolutToken);
        tokenRepository.save(token);
    }

    public void setRefreshTokenEndpoint(String refreshTokenEndpoint) {
        this.refreshTokenEndpoint = refreshTokenEndpoint;
    }

    @Override
    public String getBankId() {
        return BankId.REVOLUT_ID.getBank();
    }
}
