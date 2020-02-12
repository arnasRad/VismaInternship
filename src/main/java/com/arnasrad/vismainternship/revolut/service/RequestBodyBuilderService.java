package com.arnasrad.vismainternship.revolut.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service("revolut-request-body-builder")
public class RequestBodyBuilderService {

    @Value("${revolut.sandbox.constant.grantType}")
    private String grantType;

    @Value("${revolut.sandbox.constant.jwtToken}")
    private String jwtToken;

    @Value("${revolut.sandbox.constant.refreshToken}")
    private String refreshTokenConstant;

    @Value("${revolut.sandbox.constant.clientId}")
    private String clientId;

    @Value("${revolut.sandbox.constant.clientAssertionType}")
    private String clientAssertionType;

    public MultiValueMap<String, String> getJwtRequestParams() {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", grantType);
        params.add("refresh_token", refreshTokenConstant);
        params.add("client_id", clientId);
        params.add("client_assertion_type", clientAssertionType);
        params.add("client_assertion", jwtToken);

        return params;
    }
}
