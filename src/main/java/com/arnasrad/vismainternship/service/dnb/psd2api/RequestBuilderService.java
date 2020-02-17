package com.arnasrad.vismainternship.service.dnb.psd2api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service("dnb-psd2-request-builder")
public class RequestBuilderService {

    @Autowired
    private DnbPsd2HeaderBuilderService dnbPsd2HeaderBuilderService;

    @Autowired
    private DnbPsd2RequestBodyBuilderService dnbPsd2RequestBodyBuilderService;

    public HttpEntity<String> getRequest() {

        return new HttpEntity<>(dnbPsd2HeaderBuilderService.getHttpHeaders());
    }

    public HttpEntity<String> getAuthorizedRequest() {

        return new HttpEntity<>(dnbPsd2HeaderBuilderService.getAuthorizedHttpHeaders());
    }

    public HttpEntity<String> getRequestWithSSN() {

        return new HttpEntity<>(dnbPsd2RequestBodyBuilderService.getBodyForRequestWithSSN(),
                dnbPsd2HeaderBuilderService.getHttpHeaders());
    }


}
