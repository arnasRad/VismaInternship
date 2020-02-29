package com.arnasrad.vismainternship.service.revolut.builder;

import com.arnasrad.vismainternship.service.revolut.RevolutTokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class RevolutHeaderBuilderService {

    private final RevolutTokenService revolutTokenService;
    @Value("${authorization.headerName}")
    private String headerName;
    @Value("${authorization.headerType}")
    private String headerType;

    public RevolutHeaderBuilderService(RevolutTokenService revolutTokenService) {
        this.revolutTokenService = revolutTokenService;
    }

    public HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        return httpHeaders;
    }

    public HttpHeaders getAuthorizedHeaders() {
        String token = revolutTokenService.get();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(headerName, headerType.concat(" ").concat(token));
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
