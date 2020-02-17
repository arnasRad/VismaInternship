package com.arnasrad.vismainternship.service.revolut;

import com.arnasrad.vismainternship.component.JsonMapper;
import com.arnasrad.vismainternship.component.revolut.AccessToken;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class RefreshTokenService {

    @Value("${revolut.endpoint.access-token}")
    private String refreshTokenEndpoint;

    private final RevolutRequestBuilderService revolutRequestBuilderService;
    private final RestTemplate restTemplate;
    private final JsonMapper jsonMapper;
    private final AccessToken accessToken;

    @Autowired
    public RefreshTokenService(RevolutRequestBuilderService revolutRequestBuilderService, RestTemplate restTemplate, JsonMapper jsonMapper, AccessToken accessToken) {

        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.restTemplate = restTemplate;
        this.jsonMapper = jsonMapper;
        this.accessToken = accessToken;
    }

    public String refreshAndGetAccessToken() {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(refreshTokenEndpoint, HttpMethod.POST,
                revolutRequestBuilderService.getJwtRequest(), String.class).getBody()
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad token refresh request"));

        String token = jsonMapper.getFieldFromResponse(jsonResponse, "access_token");
        accessToken.setToken(token);
        return token;
    }
}
