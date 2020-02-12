package com.arnasrad.vismainternship.revolut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service("revolut-request-builder")
public class RequestBuilderService {

    @Autowired
    @Qualifier("revolut-request-header-builder")
    private HeaderBuilderService headerBuilderService;

    @Autowired
    @Qualifier("revolut-request-body-builder")
    private RequestBodyBuilderService requestBodyBuilderService;

    public HttpEntity<String> getAuthorizedRequest() {

        return new HttpEntity<>(headerBuilderService.getAuthorizedHttpHeaders());
    }

    public HttpEntity<MultiValueMap<String, String>> getJwtRequest() {

        MultiValueMap<String, String> params = requestBodyBuilderService.getJwtRequestParams();
        HttpHeaders httpHeaders = headerBuilderService.getHttpHeaders();
        return new HttpEntity<>(params, httpHeaders);
    }
}
