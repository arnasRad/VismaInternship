package com.arnasrad.vismainternship.service.revolut;

import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.token.RevolutToken;
import com.arnasrad.vismainternship.service.request.TokenService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import com.arnasrad.vismainternship.token.RevolutAccessToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class RefreshAccessTokenService implements TokenService {
    @Value("${revolut.endpoint.access-token}")
    private String refreshTokenEndpoint;

    private final RevolutRequestBuilderService revolutRequestBuilderService;
    private final RestTemplate restTemplate;
    private final RevolutAccessToken revolutAccessToken;

    public RefreshAccessTokenService(RevolutRequestBuilderService revolutRequestBuilderService,
                                     RestTemplate restTemplate, RevolutAccessToken revolutAccessToken) {
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.restTemplate = restTemplate;
        this.revolutAccessToken = revolutAccessToken;
    }

    @Override
    public String refreshAndGetToken(String ssn) {
        RevolutToken token = refreshToken();
        return setNewToken(token);
    }

    private RevolutToken refreshToken() {
        HttpEntity<MultiValueMap<String, String>> httpEntity = revolutRequestBuilderService.getAccessTokenRequest();

        ResponseEntity<RevolutToken> responseEntity = restTemplate.exchange(refreshTokenEndpoint, HttpMethod.POST,
                httpEntity, RevolutToken.class);

        return responseEntity.getBody();
    }

    private String setNewToken(RevolutToken revolutToken) {
        String token = revolutToken.getAccessToken();
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
