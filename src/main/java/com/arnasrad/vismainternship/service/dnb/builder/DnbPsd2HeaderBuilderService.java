package com.arnasrad.vismainternship.service.dnb.builder;

import com.arnasrad.vismainternship.model.entity.token.Token;
import com.arnasrad.vismainternship.persistence.token.TokenRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DnbPsd2HeaderBuilderService {

    private final TokenRepository tokenRepository;
    @Value("${dnb.psd2.psu-id}")
    private String psuId;
    @Value("${dnb.psd2.psu-ip-address}")
    private String psuIpAddress;
    @Value("${dnb.psd2.redirect-uri}")
    private String redirectUri;

    public DnbPsd2HeaderBuilderService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public HttpHeaders getAuthorizedHttpHeaders() {
        Token token = tokenRepository.findById(psuId)
                .orElse(new Token());

        String consent = token.getToken();

        HttpHeaders httpHeaders = getHttpHeaders();
        httpHeaders.add("Consent-ID", consent);
        httpHeaders.add("PSU-IP-Address", psuIpAddress);

        return httpHeaders;
    }

    public HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.add("Content-type", MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.add("X-Request-ID", UUID.randomUUID().toString());
        httpHeaders.add("TPP-Redirect-Preferred", "true");
        httpHeaders.add("TPP-Redirect-URI", redirectUri);
        httpHeaders.add("PSU-ID", psuId);

        return httpHeaders;
    }
}
