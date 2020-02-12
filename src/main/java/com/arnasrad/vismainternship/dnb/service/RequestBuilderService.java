package com.arnasrad.vismainternship.dnb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service("dnb-request-builder")
public class RequestBuilderService {

    @Autowired
    @Qualifier("dnb-header-builder")
    private HeaderBuilderService headerBuilderService;

    @Autowired
    @Qualifier("dnb-request-body-builder")
    private RequestBodyBuilderService requestBodyBuilderService;

    public HttpEntity<String> getRequest() {

        return new HttpEntity<>(headerBuilderService.getHttpHeaders());
    }

    public HttpEntity<String> getAuthorizedRequest() {

        return new HttpEntity<>(headerBuilderService.getAuthorizedHttpHeaders());
    }

    public HttpEntity<String> getRequestWithSSN() {

        return new HttpEntity<>(requestBodyBuilderService.getBodyForRequestWithSSN(),
                headerBuilderService.getHttpHeaders());
    }

}
