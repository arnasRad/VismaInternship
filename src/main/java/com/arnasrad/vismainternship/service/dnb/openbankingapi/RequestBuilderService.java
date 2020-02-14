package com.arnasrad.vismainternship.service.dnb.openbankingapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service("dnb-openbanking-request-builder")
public class RequestBuilderService {

    @Autowired
    @Qualifier("dnb-openbanking-header-builder")
    private HeaderBuilderService headerBuilderService;

    @Autowired
    @Qualifier("dnb-openbanking-request-body-builder")
    private RequestBodyBuilderService requestBodyBuilderService;

    public HttpEntity<String> getRequest() {

        return new HttpEntity<>(headerBuilderService.getHttpHeaders());
    }

    public HttpEntity<String> getRequest(String ssn) {

        return new HttpEntity<>(requestBodyBuilderService.getBodyForRequestWithSSN(ssn),
                headerBuilderService.getHttpHeaders());
    }

    public HttpEntity<String> getAuthorizedRequest() {

        return new HttpEntity<>(headerBuilderService.getAuthorizedHttpHeaders());
    }

    public HttpEntity<String> getAuthorizedRequest(String ssn) {

        return new HttpEntity<>(requestBodyBuilderService.getBodyForRequestWithSSN(ssn),
                headerBuilderService.getAuthorizedHttpHeaders());
    }


}
