package com.arnasrad.vismainternship.service.dnb.openbankingapi.builder;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service
public class DnbRequestBuilderService {

    private final DnbHeaderBuilderService dnbHeaderBuilderService;

    public DnbRequestBuilderService(DnbHeaderBuilderService dnbHeaderBuilderService) {
        this.dnbHeaderBuilderService = dnbHeaderBuilderService;
    }

    public HttpEntity<String> getRequest() {
        return new HttpEntity<>(dnbHeaderBuilderService.getHttpHeaders());
    }

    public HttpEntity<String> getRequest(JSONObject ssn) {
        return new HttpEntity<>(ssn.toString(), dnbHeaderBuilderService.getHttpHeaders());
    }

    public HttpEntity<String> getAuthorizedRequest() {
        return new HttpEntity<>(dnbHeaderBuilderService.getAuthorizedHttpHeaders());
    }

    public HttpEntity<String> getAuthorizedRequest(JSONObject ssn) {
        return new HttpEntity<>(ssn.toString(), dnbHeaderBuilderService.getAuthorizedHttpHeaders());
    }


}
