package com.arnasrad.vismainternship.service.dnb.openbankingapi;

import com.arnasrad.vismainternship.component.JsonMapper;
import com.arnasrad.vismainternship.component.dnb.JwtToken;
import com.arnasrad.vismainternship.service.dnb.openbankingapi.builder.DnbRequestBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class RefreshJwtTokenService {

    @Value("${dnb.openbanking.endpoint.access-token}")
    private String accessTokenEndpoint;

    private final RestTemplate restTemplate;
    private final DnbRequestBuilderService dnbRequestBuilderService;
    private final JsonMapper jsonMapper;
    private final JwtToken jwtToken;

    @Autowired
    public RefreshJwtTokenService(RestTemplate restTemplate, DnbRequestBuilderService dnbRequestBuilderService, JsonMapper jsonMapper, JwtToken jwtToken) {

        this.restTemplate = restTemplate;
        this.dnbRequestBuilderService = dnbRequestBuilderService;
        this.jsonMapper = jsonMapper;
        this.jwtToken = jwtToken;
    }

    public String refreshAndGetJwtToken(String ssn) {

        String jsonResponse = refreshJwtToken(ssn);
        return setNewJwtToken(jsonResponse);
    }

    private String refreshJwtToken(String ssn) {

        return Optional.ofNullable(restTemplate.postForEntity(accessTokenEndpoint,
                dnbRequestBuilderService.getRequest(ssn), String.class).getBody())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad customers request"));
    }

    private String setNewJwtToken(String jsonResponse) {

        String token = jsonMapper.getFieldFromResponse(jsonResponse, "jwtToken");
        jwtToken.setToken(token);
        return token;
    }
}
