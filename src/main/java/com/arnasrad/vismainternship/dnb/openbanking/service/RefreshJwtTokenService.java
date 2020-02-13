package com.arnasrad.vismainternship.dnb.openbanking.service;

import com.arnasrad.vismainternship.component.JsonMapper;
import com.arnasrad.vismainternship.dnb.component.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("dnb-openbanking-request-builder")
    private RequestBuilderService requestBuilderService;

    @Autowired
    private JsonMapper jsonMapper;

    @Autowired
    private JwtToken jwtToken;

    public String refreshAndGetJwtToken(String ssn) {

        String jsonResponse = Optional.ofNullable(restTemplate.postForEntity(accessTokenEndpoint,
                requestBuilderService.getRequest(ssn), String.class).getBody())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad customers request"));

        String token = jsonMapper.getFieldFromResponse(jsonResponse, "jwtToken");
        jwtToken.setToken(token);
        return token;
    }
}
