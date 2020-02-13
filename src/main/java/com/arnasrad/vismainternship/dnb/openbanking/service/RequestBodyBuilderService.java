package com.arnasrad.vismainternship.dnb.openbanking.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("dnb-openbanking-request-body-builder")
public class RequestBodyBuilderService {

    public String getBodyForRequestWithSSN(String ssn) {

        JSONObject body = new JSONObject();
        body.put("ssn", ssn);

        return body.toString();
    }
}
