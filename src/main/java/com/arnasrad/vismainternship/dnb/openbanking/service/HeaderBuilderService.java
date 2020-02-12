package com.arnasrad.vismainternship.dnb.openbanking.service;

import com.arnasrad.vismainternship.dnb.component.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service("dnb-openbanking-header-builder")
public class HeaderBuilderService {

    @Value("${dnb.api.keyHeader}")
    private String apiKeyHeader;

    @Value("${dnb.jwt.tokenHeader}")
    private String jwtTokenHeader;

    @Value("${dnb.apikey}")
    private String apiKey;

    @Autowired
    private JwtToken jwtToken;

    public HttpHeaders getAuthorizedHttpHeaders() {

        HttpHeaders httpHeaders = getHttpHeaders();
        httpHeaders.add(jwtTokenHeader, jwtToken.getToken());

        return httpHeaders;
    }

    public HttpHeaders getHttpHeaders() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.add("Content-type", MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.add(apiKeyHeader, apiKey);

        return httpHeaders;
    }
}
