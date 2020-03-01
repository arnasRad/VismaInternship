package com.arnasrad.vismainternship.service.revolut.builder;

import com.arnasrad.vismainternship.model.entity.token.Token;
import com.arnasrad.vismainternship.persistence.token.TokenRepository;
import com.arnasrad.vismainternship.service.revolut.RevolutTokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class RevolutHeaderBuilderService {

    private TokenRepository tokenRepository;
    @Value("${authorization.headerName}")
    private String headerName;
    @Value("${authorization.headerType}")
    private String headerType;
    @Value("${revolut.sandbox.constant.clientId}")
    private String clientId;

    public RevolutHeaderBuilderService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        return httpHeaders;
    }

    public HttpHeaders getAuthorizedHeaders() {
        Token token = tokenRepository.findById(clientId)
                .orElse(new Token());

        String tokenString = token.getToken();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(headerName, headerType.concat(" ").concat(tokenString));
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return httpHeaders;
    }

    public HttpHeaders getAuthorizedJsonHeaders() {
        HttpHeaders httpHeaders = getAuthorizedHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return httpHeaders;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public void setHeaderType(String headerType) {
        this.headerType = headerType;
    }
}
