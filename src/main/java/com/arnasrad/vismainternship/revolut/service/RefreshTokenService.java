package com.arnasrad.vismainternship.revolut.service;

import com.arnasrad.vismainternship.component.JsonMapper;
import com.arnasrad.vismainternship.revolut.component.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    @Qualifier("revolut-request-builder")
    private RequestBuilderService requestBuilderService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JsonMapper jsonMapper;

    @Autowired
    private AccessToken accessToken;

    public String refreshAndGetAccessToken() {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(refreshTokenEndpoint, HttpMethod.POST,
                requestBuilderService.getJwtRequest(), String.class).getBody()
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad token refresh request"));

        String token = jsonMapper.getFieldFromResponse(jsonResponse, "access_token");
        accessToken.setToken(token);
        return token;
    }
}
