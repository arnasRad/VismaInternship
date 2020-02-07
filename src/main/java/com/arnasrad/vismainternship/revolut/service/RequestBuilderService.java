package com.arnasrad.vismainternship.revolut.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class RequestBuilderService {

    @Value("${revolut.sandbox.constant.accessToken}")
    private String accessToken;

    @Value("${authorization.headerName}")
    private String headerName;

    @Value("${authorization.headerType}")
    private String headerType;

    public HttpEntity<String> getAuthorizedHttpEntity() {

        return new HttpEntity<>(getAuthorizedHttpHeaders());
    }

    private HttpHeaders getAuthorizedHttpHeaders() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(headerName, headerType + " " + accessToken);
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        httpHeaders.remove(headerName);
        httpHeaders.add(headerName, headerType + " " + accessToken);
        return httpHeaders;
    }

}
