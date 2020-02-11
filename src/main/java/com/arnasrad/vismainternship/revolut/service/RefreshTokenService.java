package com.arnasrad.vismainternship.revolut.service;

import com.arnasrad.vismainternship.revolut.component.JsonResponseMapper;
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

    @Value("${url.revolut.access.token}")
    private String refreshTokenUrl;

    @Autowired
    private RequestBuilderService requestBuilderService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JsonResponseMapper jsonResponseMapper;

    public String refreshAndGetAccessToken() {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(refreshTokenUrl, HttpMethod.POST,
                requestBuilderService.getJwtHttpEntity(),
                String.class).getBody()
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad token refresh request"));

        // TODO: update access token property
        return jsonResponseMapper.getFieldFromResponse(jsonResponse, "access_token");
    }
}
