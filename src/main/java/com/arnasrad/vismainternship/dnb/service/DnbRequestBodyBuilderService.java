package com.arnasrad.vismainternship.dnb.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DnbRequestBodyBuilderService {

    @Value("${dnb.ssn}")
    private String ssn;

    public String getBodyForRequestWithSSN() {

        JSONObject body = new JSONObject();
        body.put("ssn", ssn);

        return body.toString();
    }
}
