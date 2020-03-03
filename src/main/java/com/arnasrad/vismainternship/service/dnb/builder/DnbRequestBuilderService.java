package com.arnasrad.vismainternship.service.dnb.builder;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

@Service
public class DnbRequestBuilderService {

    private final DnbHeaderBuilderService dnbHeaderBuilderService;
    @Value("${dnb.openbanking.ssn}")
    private String ssn;

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
