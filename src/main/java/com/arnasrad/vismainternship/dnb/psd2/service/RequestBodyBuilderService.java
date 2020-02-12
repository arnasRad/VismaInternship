package com.arnasrad.vismainternship.dnb.psd2.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("dnb-psd2-request-body-builder")
public class RequestBodyBuilderService {

    @Value("${dnb.openbanking.ssn}")
    private String ssn;

    public String getBodyForRequestWithSSN() {

        JSONObject body = new JSONObject();
        body.put("ssn", ssn);

        return body.toString();
    }
}
