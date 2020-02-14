package com.arnasrad.vismainternship.revolut.service;

import com.arnasrad.vismainternship.revolut.model.requestbody.CounterpartyRequestBody;
import com.arnasrad.vismainternship.revolut.model.requestbody.TransferRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service("revolut-request-builder")
public class RequestBuilderService {

    @Autowired
    @Qualifier("revolut-request-header-builder")
    private HeaderBuilderService headerBuilderService;

    @Autowired
    @Qualifier("revolut-request-body-builder")
    private RequestBodyBuilderService requestBodyBuilderService;

    public HttpEntity<String> getAuthorizedRequest() {

        return new HttpEntity<>(headerBuilderService.getAuthorizedHeaders());
    }

    public HttpEntity<MultiValueMap<String, String>> getJwtRequest() {

        MultiValueMap<String, String> body = requestBodyBuilderService.getJwtRequestBody();
        HttpHeaders headers = headerBuilderService.getHttpHeaders();
        return new HttpEntity<>(body, headers);
    }

    public HttpEntity<String> getCounterpartyRequest(CounterpartyRequestBody body) {

        String requestBody = requestBodyBuilderService.getCounterpartyRequestBody(body);
        HttpHeaders headers = headerBuilderService.getAuthorizedJsonHeaders();
        return new HttpEntity<>(requestBody, headers);
    }

    public HttpEntity<String> getCounterpartiesRequest() {

        return new HttpEntity<>(headerBuilderService.getAuthorizedHeaders());
    }

    public HttpEntity<String> getTransferRequest(TransferRequestBody body) {

        String requestBody = requestBodyBuilderService.getTransferRequestBody(body);
        HttpHeaders headers = headerBuilderService.getAuthorizedJsonHeaders();
        return new HttpEntity<>(requestBody, headers);
    }
}
