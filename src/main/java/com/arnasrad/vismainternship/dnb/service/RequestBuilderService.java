package com.arnasrad.vismainternship.dnb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service("dnb")
public class RequestBuilderService {

    @Autowired
    private DnbHeaderBuilderService dnbHeaderBuilderService;

    @Autowired
    private DnbRequestBodyBuilderService dnbRequestBodyBuilderService;

    public HttpEntity<String> getRequest() {

        return new HttpEntity<>(dnbHeaderBuilderService.getHttpHeaders());
    }

    public HttpEntity<String> getAuthorizedRequest() {

        return new HttpEntity<>(dnbHeaderBuilderService.getAuthorizedHttpHeaders());
    }

    public HttpEntity<String> getRequestWithSSN() {

        return new HttpEntity<>(dnbRequestBodyBuilderService.getBodyForRequestWithSSN(),
                dnbHeaderBuilderService.getHttpHeaders());
    }

}
