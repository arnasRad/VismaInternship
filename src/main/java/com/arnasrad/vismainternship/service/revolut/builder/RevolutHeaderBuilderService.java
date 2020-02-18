package com.arnasrad.vismainternship.service.revolut.builder;

import com.arnasrad.vismainternship.token.RevolutAccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class RevolutHeaderBuilderService {

    @Value("${authorization.headerName}")
    private String headerName;

    @Value("${authorization.headerType}")
    private String headerType;

    private final RevolutAccessToken revolutAccessToken;

    @Autowired
    public RevolutHeaderBuilderService(RevolutAccessToken revolutAccessToken) {
        this.revolutAccessToken = revolutAccessToken;
    }

    public HttpHeaders getAuthorizedHeaders() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(headerName, headerType + " " + revolutAccessToken.getToken());
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return httpHeaders;
    }

    public HttpHeaders getAuthorizedJsonHeaders() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(headerName, headerType + " " + revolutAccessToken.getToken());
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return httpHeaders;
    }

    public HttpHeaders getHttpHeaders() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        return httpHeaders;
    }
}
