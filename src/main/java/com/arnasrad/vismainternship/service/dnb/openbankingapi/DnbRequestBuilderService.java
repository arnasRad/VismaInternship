package com.arnasrad.vismainternship.service.dnb.openbankingapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service
public class DnbRequestBuilderService {

    @Autowired
    private DnbHeaderBuilderService dnbHeaderBuilderService;

    @Autowired
    private DnbRequestBodyBuilderService dnbRequestBodyBuilderService;

    public HttpEntity<String> getRequest() {

        return new HttpEntity<>(dnbHeaderBuilderService.getHttpHeaders());
    }

    public HttpEntity<String> getRequest(String ssn) {

        return new HttpEntity<>(dnbRequestBodyBuilderService.getBodyForRequestWithSSN(ssn),
                dnbHeaderBuilderService.getHttpHeaders());
    }

    public HttpEntity<String> getAuthorizedRequest() {

        return new HttpEntity<>(dnbHeaderBuilderService.getAuthorizedHttpHeaders());
    }

    public HttpEntity<String> getAuthorizedRequest(String ssn) {

        return new HttpEntity<>(dnbRequestBodyBuilderService.getBodyForRequestWithSSN(ssn),
                dnbHeaderBuilderService.getAuthorizedHttpHeaders());
    }


}
