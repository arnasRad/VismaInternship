package com.arnasrad.vismainternship.dnb.service;

import com.arnasrad.vismainternship.component.JsonMapper;
import com.arnasrad.vismainternship.dnb.component.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class RefreshJwtTokenService {

    @Value("${dnb.endpoint.access-token}")
    private String accessTokenEndpoint;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DnbRequestBuilderService dnbRequestBuilderService;

    @Autowired
    private JsonMapper jsonMapper;

    @Autowired
    private JwtToken jwtToken;

    public String refreshAndGetJwtToken() {

        String jsonResponse = Optional.ofNullable(restTemplate.postForEntity(accessTokenEndpoint,
                dnbRequestBuilderService.getRequestWithSSN(), String.class).getBody())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad customers request"));

        String token = jsonMapper.getFieldFromResponse(jsonResponse, "jwtToken");
        jwtToken.setToken(token);
        return token;
    }
}
