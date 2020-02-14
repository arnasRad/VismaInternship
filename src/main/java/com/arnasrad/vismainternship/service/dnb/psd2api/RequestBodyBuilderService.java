package com.arnasrad.vismainternship.service.dnb.psd2api;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("dnb-psd2-request-body-builder")
public class RequestBodyBuilderService {

    @Value("${dnb.psd2.ssn1}")
    private String ssn;

    public String getBodyForRequestWithSSN() {

        JSONObject body = new JSONObject();
        body.put("ssn", ssn);

        return body.toString();
    }
}
