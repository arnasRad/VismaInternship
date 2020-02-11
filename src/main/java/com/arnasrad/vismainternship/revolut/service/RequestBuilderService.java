package com.arnasrad.vismainternship.revolut.service;

import com.arnasrad.vismainternship.revolut.component.AccessToken;
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

    @Value("${revolut.sandbox.constant.grantType}")
    private String grantType;

    @Value("${revolut.sandbox.constant.jwtToken}")
    private String jwtToken;

    @Value("${revolut.sandbox.constant.refreshToken}")
    private String refreshTokenConstant;

    @Value("${revolut.sandbox.constant.clientId}")
    private String clientId;

    @Value("${revolut.sandbox.constant.clientAssertionType}")
    private String clientAssertionType;

    @Value("${authorization.headerName}")
    private String headerName;

    @Value("${authorization.headerType}")
    private String headerType;

    @Autowired
    AccessToken accessToken;

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
        params.add("grant_type", grantType);
        params.add("refresh_token", refreshTokenConstant);
        params.add("client_id", clientId);
        params.add("client_assertion_type", clientAssertionType);
        params.add("client_assertion", jwtToken);

        return params;
    }

    private HttpHeaders getAuthorizedHttpHeaders() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(headerName, headerType + " " + accessToken.getToken());
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return httpHeaders;
    }

    private HttpHeaders getHttpHeaders() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        return httpHeaders;
    }
}
