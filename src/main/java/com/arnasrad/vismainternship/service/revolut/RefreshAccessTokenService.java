package com.arnasrad.vismainternship.service.revolut;

import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.service.mapping.JsonMapperService;
import com.arnasrad.vismainternship.service.request.TokenService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import com.arnasrad.vismainternship.token.RevolutAccessToken;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final JsonMapperService jsonMapperService;
    private final RevolutAccessToken revolutAccessToken;

    @Autowired
    public RefreshAccessTokenService(RevolutRequestBuilderService revolutRequestBuilderService,
                                     RestTemplate restTemplate, JsonMapperService jsonMapperService, RevolutAccessToken revolutAccessToken) {

        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.restTemplate = restTemplate;
        this.jsonMapperService = jsonMapperService;
        this.revolutAccessToken = revolutAccessToken;
    }

    @Override
    public String refreshAndGetToken(String ssn) {

        String jsonResponse = refreshToken();
        return setNewToken(jsonResponse);
    }

    private String refreshToken() {

        HttpEntity<MultiValueMap<String, String>> httpEntity = revolutRequestBuilderService.getAccessTokenRequest();

        ResponseEntity<String> responseEntity = restTemplate.exchange(refreshTokenEndpoint, HttpMethod.POST, httpEntity
                , String.class);

        return responseEntity.getBody();
    }

    private String setNewToken(String jsonResponse) {

        String token = jsonMapperService.getFieldFromResponse(jsonResponse, "access_token");
        revolutAccessToken.setToken(token);
        return token;
    }

    @Override
    public String getBankId() {

        return BankId.REVOLUT_ID.getBank();
    }
}
