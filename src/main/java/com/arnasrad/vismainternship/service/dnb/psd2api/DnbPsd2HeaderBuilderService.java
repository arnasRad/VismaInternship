package com.arnasrad.vismainternship.service.dnb.psd2api;

import com.arnasrad.vismainternship.token.DnbJwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class DnbPsd2HeaderBuilderService {

    @Value("${dnb.api.keyHeader}")
    private String apiKeyHeader;

    @Value("${dnb.jwt.tokenHeader}")
    private String jwtTokenHeader;

    @Value("${dnb.apikey}")
    private String apiKey;

    private final DnbJwtToken dnbJwtToken;

    @Autowired
    public DnbPsd2HeaderBuilderService(DnbJwtToken dnbJwtToken) {
        this.dnbJwtToken = dnbJwtToken;
    }

    public HttpHeaders getAuthorizedHttpHeaders() {

        HttpHeaders httpHeaders = getHttpHeaders();
        httpHeaders.add(jwtTokenHeader, dnbJwtToken.getToken());

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
