package com.arnasrad.vismainternship.service.dnb.openbankingapi.builder;

import com.arnasrad.vismainternship.component.dnb.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service()
public class DnbHeaderBuilderService {

    @Value("${dnb.api.keyHeader}")
    private String apiKeyHeader;

    @Value("${dnb.jwt.tokenHeader}")
    private String jwtTokenHeader;

    @Value("${dnb.apikey}")
    private String apiKey;

    private final JwtToken jwtToken;

    @Autowired
    public DnbHeaderBuilderService(JwtToken jwtToken) {

        this.jwtToken = jwtToken;
    }

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
