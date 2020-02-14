package com.arnasrad.vismainternship.service.dnb.openbankingapi;

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
