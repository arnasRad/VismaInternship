package com.arnasrad.vismainternship.service.dnb.builder;

import com.arnasrad.vismainternship.model.entity.token.Token;
import com.arnasrad.vismainternship.persistence.token.TokenRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class DnbHeaderBuilderService {

    private final TokenRepository tokenRepository;
    @Value("${dnb.openbanking.keyHeader}")
    private String apiKeyHeader;
    @Value("${dnb.openbanking.jwt.tokenHeader}")
    private String jwtTokenHeader;
    @Value("${dnb.openbanking.apikey}")
    private String apiKey;
    @Value("${dnb.openbanking.ssn}")
    private String ssn;

    public DnbHeaderBuilderService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public HttpHeaders getAuthorizedHttpHeaders() {
        Token token = tokenRepository.findById(ssn)
                .orElse(new Token());

        String tokenString = token.getToken();

        HttpHeaders httpHeaders = getHttpHeaders();
        httpHeaders.add(jwtTokenHeader, tokenString);

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
