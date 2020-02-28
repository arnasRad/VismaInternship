package com.arnasrad.vismainternship.service.revolut;

import com.arnasrad.vismainternship.mapper.TokenMapper;
import com.arnasrad.vismainternship.model.dto.token.RevolutTokenDTO;
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

import java.util.Optional;

@Service
public class RefreshAccessTokenService implements TokenService {
    private final RevolutRequestBuilderService revolutRequestBuilderService;
    private final RestTemplate restTemplate;
    private final TokenRepository tokenRepository;
    private final TokenMapper tokenMapper;
    @Value("${revolut.endpoint.access-token}")
    private String refreshTokenEndpoint;

    public RefreshAccessTokenService(RevolutRequestBuilderService revolutRequestBuilderService,
                                     RestTemplate restTemplate, TokenRepository tokenRepository,
                                     TokenMapper tokenMapper) {
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.restTemplate = restTemplate;
        this.tokenRepository = tokenRepository;
        this.tokenMapper = tokenMapper;
    }

    @Override
    public void refresh() {
        HttpEntity<MultiValueMap<String, String>> httpEntity = revolutRequestBuilderService.getAccessTokenRequest();

        ResponseEntity<RevolutTokenDTO> responseEntity = restTemplate.exchange(refreshTokenEndpoint, HttpMethod.POST,
                httpEntity, RevolutTokenDTO.class);

        RevolutTokenDTO newToken = responseEntity.getBody();
        save(newToken);
        tokenRepository.save()
    }

    @Override
    public String get(String userId) {
        return null;
    }

    @Override
    public String refreshAndGetToken(String ssn) {
        RevolutTokenDTO token = refreshToken();
        return setNewToken(token);
    }

    private RevolutTokenDTO refreshToken() {
    }

    private String save(RevolutTokenDTO revolutToken) {
        Optional<Token> token = tokenRepository.findById(revolutToken.getClientId());
        if (token.isPresent()) {
            token.
        } else {

        }
        revolutAccessToken.setToken(token);
        return token;
    }

    public void setRefreshTokenEndpoint(String refreshTokenEndpoint) {
        this.refreshTokenEndpoint = refreshTokenEndpoint;
    }

    @Override
    public String getBankId() {
        return BankId.REVOLUT_ID.getBank();
    }
}
