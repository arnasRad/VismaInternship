package com.arnasrad.vismainternship.service.dnb.openbankingapi;

import com.arnasrad.vismainternship.model.dto.token.DNBTokenDTO;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.service.dnb.openbankingapi.builder.DnbRequestBuilderService;
import com.arnasrad.vismainternship.service.request.TokenService;
import com.arnasrad.vismainternship.token.DnbJwtToken;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RefreshJwtTokenService implements TokenService {

    private final RestTemplate restTemplate;
    private final DnbRequestBuilderService dnbRequestBuilderService;
    private final DnbJwtToken dnbJwtToken;
    @Value("${dnb.openbanking.endpoint.access-token}")
    private String accessTokenEndpoint;

    public RefreshJwtTokenService(RestTemplate restTemplate, DnbRequestBuilderService dnbRequestBuilderService,
                                  DnbJwtToken dnbJwtToken) {
        this.restTemplate = restTemplate;
        this.dnbRequestBuilderService = dnbRequestBuilderService;
        this.dnbJwtToken = dnbJwtToken;
    }

    @Override
    public String refreshAndGetToken(String ssn) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ssn", ssn);

        DNBTokenDTO jsonResponse = getRefreshTokenJsonResponse(jsonObject);
        return refreshToken(jsonResponse);
    }

    private DNBTokenDTO getRefreshTokenJsonResponse(JSONObject ssn) {
        HttpEntity<String> httpEntity = dnbRequestBuilderService.getRequest(ssn);

        ResponseEntity<DNBTokenDTO> responseEntity = restTemplate.postForEntity(accessTokenEndpoint, httpEntity,
                DNBTokenDTO.class);

        return responseEntity.getBody();
    }

    private String refreshToken(DNBTokenDTO dnbToken) {
        String token = dnbToken.getJwtToken();
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
