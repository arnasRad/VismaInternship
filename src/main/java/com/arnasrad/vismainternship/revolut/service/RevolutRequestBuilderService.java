package com.arnasrad.vismainternship.revolut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
public class RevolutRequestBuilderService {

    @Autowired
    RevolutHeaderBuilderService revolutHeaderBuilderService;

    @Autowired
    RevolutRequestBodyBuilderService revolutRequestBodyBuilderService;

    public HttpEntity<String> getAuthorizedRequest() {

        return new HttpEntity<>(revolutHeaderBuilderService.getAuthorizedHttpHeaders());
    }

    public HttpEntity<MultiValueMap<String, String>> getJwtRequest() {

        MultiValueMap<String, String> params = revolutRequestBodyBuilderService.getJwtRequestParams();
        HttpHeaders httpHeaders = revolutHeaderBuilderService.getHttpHeaders();
        return new HttpEntity<>(params, httpHeaders);
    }
}
