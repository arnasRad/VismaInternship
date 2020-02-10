package com.arnasrad.vismainternship.revolut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class RequestBuilderService {

    @Value("${revolut.sandbox.constant.accessToken}")
    private String accessToken;

    @Value("${revolut.sandbox.constant.jwtToken")
    private String jwtToken;

    @Value("${revolut.sandbox.constant.refreshToken}")
    private String refreshTokenConstant;

    @Value("${revolut.sandbox.constant.clientId}")
    private String clientId;

    @Value("${authorization.headerName}")
    private String headerName;

    @Value("${authorization.headerType}")
    private String headerType;

    @Autowired
    private JwtTokenService jwtTokenService;

    public HttpEntity<String> getAuthorizedHttpEntity() {

        return new HttpEntity<>(getAuthorizedHttpHeaders());
    }

    public HttpEntity<MultiValueMap<String, String>> getJwtHttpEntity() {

        MultiValueMap<String, String> params = setupJwtParams();
        HttpHeaders httpHeaders = getHttpHeaders();
        return new HttpEntity<>(params, httpHeaders);
    }

    private MultiValueMap<String, String> setupJwtParams() {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "refresh_token"); // value="refresh_token"
        params.add("refresh_token", refreshTokenConstant); // value=a_refresh_token
        params.add("client_id", clientId); // value=your_app_id
        params.add("client_assertion_type", "urn:ietf:params:oauth:client-assertion-type:jwt-bearer"); // value="urn:ietf:params:oauth:client-assertion-type:jwt-bearer"
        params.add("client_assertion", jwtToken); // value=generated_jwt_token

        return params;
    }

    private HttpHeaders getAuthorizedHttpHeaders() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(headerName, headerType + " " + accessToken);
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        httpHeaders.remove(headerName);
        httpHeaders.add(headerName, headerType + " " + accessToken);
        return httpHeaders;
    }

    private HttpHeaders getHttpHeaders() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        return httpHeaders;
    }
}
