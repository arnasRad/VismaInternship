package com.arnasrad.vismainternship.dnb.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class RequestBuilderService {


    /*
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
    */
}
