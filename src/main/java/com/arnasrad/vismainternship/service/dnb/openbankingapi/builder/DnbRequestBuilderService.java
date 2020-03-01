package com.arnasrad.vismainternship.service.dnb.openbankingapi.builder;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service
public class DnbRequestBuilderService {

    @Value("${dnb.openbanking.ssn}")
    private String ssn;

    private final DnbHeaderBuilderService dnbHeaderBuilderService;

    public DnbRequestBuilderService(DnbHeaderBuilderService dnbHeaderBuilderService) {
        this.dnbHeaderBuilderService = dnbHeaderBuilderService;
    }

    public HttpEntity<String> getRequest() {
        JSONObject body = new JSONObject();
        body.put("ssn", ssn);
        return new HttpEntity<>(body.toString(), dnbHeaderBuilderService.getHttpHeaders());
    }

    public HttpEntity<String> getAuthorizedRequest() {
        return new HttpEntity<>(dnbHeaderBuilderService.getAuthorizedHttpHeaders());
    }


}
