package com.arnasrad.vismainternship.service.dnb.openbankingapi;

import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.service.dnb.openbankingapi.builder.DnbRequestBuilderService;
import com.arnasrad.vismainternship.service.mapping.JsonMapperService;
import com.arnasrad.vismainternship.service.request.TokenService;
import com.arnasrad.vismainternship.token.DnbJwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RefreshJwtTokenService implements TokenService {

    @Value("${dnb.openbanking.endpoint.access-token}")
    private String accessTokenEndpoint;

    private final RestTemplate restTemplate;
    private final DnbRequestBuilderService dnbRequestBuilderService;
    private final JsonMapperService jsonMapperService;
    private final DnbJwtToken dnbJwtToken;

    @Autowired
    public RefreshJwtTokenService(RestTemplate restTemplate, DnbRequestBuilderService dnbRequestBuilderService, JsonMapperService jsonMapperService, DnbJwtToken dnbJwtToken) {

        this.restTemplate = restTemplate;
        this.dnbRequestBuilderService = dnbRequestBuilderService;
        this.jsonMapperService = jsonMapperService;
        this.dnbJwtToken = dnbJwtToken;
    }

    @Override
    public String refreshAndGetToken(String ssn) {

        String jsonResponse = getRefreshTokenJsonResponse(ssn);
        return refreshToken(jsonResponse);
    }

    private String getRefreshTokenJsonResponse(String ssn){

        HttpEntity<String> httpEntity = dnbRequestBuilderService.getRequest(ssn);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(accessTokenEndpoint, httpEntity,
                String.class);

        return responseEntity.getBody();
    }

    private String refreshToken(String jsonResponse) {

        String token = jsonMapperService.getFieldFromResponse(jsonResponse, "jwtToken");
        dnbJwtToken.setToken(token);
        return token;
    }

    public void setAccessTokenEndpoint(String accessTokenEndpoint) {
        this.accessTokenEndpoint = accessTokenEndpoint;
    }

    @Override
    public String getBankId() {

        return BankId.DNB_ID.getBank();
    }
}
