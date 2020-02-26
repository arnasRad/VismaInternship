package com.arnasrad.vismainternship.service.revolut.builder;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.UUID;

@Service
public class RevolutRequestBuilderService {
    private final RevolutHeaderBuilderService revolutHeaderBuilderService;
    private final RevolutRequestBodyService revolutRequestBodyService;

    public RevolutRequestBuilderService(RevolutHeaderBuilderService revolutHeaderBuilderService, RevolutRequestBodyService revolutRequestBodyService) {
        this.revolutHeaderBuilderService = revolutHeaderBuilderService;
        this.revolutRequestBodyService = revolutRequestBodyService;
    }

    public HttpEntity<String> getAuthorizedRequest() {
        return new HttpEntity<>(revolutHeaderBuilderService.getAuthorizedHeaders());
    }

    public HttpEntity<String> getAuthorizedJsonRequestWithBody(JSONObject body) {
        String jsonBody = body.toString();
        HttpHeaders headers = revolutHeaderBuilderService.getAuthorizedJsonHeaders();
        return new HttpEntity<>(jsonBody, headers);
    }

    public HttpEntity<MultiValueMap<String, String>> getAccessTokenRequest() {
        MultiValueMap<String, String> body = revolutRequestBodyService.getAccessTokenRequestParams();
        HttpHeaders headers = revolutHeaderBuilderService.getHttpHeaders();
        return new HttpEntity<>(body, headers);
    }

    public HttpEntity<String> getPaymentRequest(JSONObject body) {
        body.put("request_id", UUID.randomUUID());
        return getAuthorizedJsonRequestWithBody(body);
    }
}
