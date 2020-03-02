package com.arnasrad.vismainternship.service.dnb.psd2api.builder;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service
public class DnbPsd2RequestBuilderService {

    private final DnbPsd2HeaderBuilderService dnbPsd2HeaderBuilderService;
    private final DnbPsd2RequestBodyBuilderService dnbPsd2RequestBodyBuilderService;

    public DnbPsd2RequestBuilderService(DnbPsd2HeaderBuilderService dnbPsd2HeaderBuilderService, DnbPsd2RequestBodyBuilderService dnbPsd2RequestBodyBuilderService) {
        this.dnbPsd2HeaderBuilderService = dnbPsd2HeaderBuilderService;
        this.dnbPsd2RequestBodyBuilderService = dnbPsd2RequestBodyBuilderService;
    }

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