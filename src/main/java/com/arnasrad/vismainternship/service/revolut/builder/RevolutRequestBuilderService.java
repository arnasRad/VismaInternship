package com.arnasrad.vismainternship.service.revolut.builder;

import com.arnasrad.vismainternship.model.revolut.requestbody.CounterpartyRequestBody;
import com.arnasrad.vismainternship.model.revolut.requestbody.CreatePaymentRequestBody;
import com.arnasrad.vismainternship.model.revolut.requestbody.TransferRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.Date;

@Service
public class RevolutRequestBuilderService {

    private final RevolutHeaderBuilderService revolutHeaderBuilderService;
    private final RevolutRequestBodyBuilderService revolutRequestBodyBuilderService;

    @Autowired
    public RevolutRequestBuilderService(RevolutHeaderBuilderService revolutHeaderBuilderService, RevolutRequestBodyBuilderService revolutRequestBodyBuilderService) {

        this.revolutHeaderBuilderService = revolutHeaderBuilderService;
        this.revolutRequestBodyBuilderService = revolutRequestBodyBuilderService;
    }

    public HttpEntity<String> getAuthorizedRequest() {

        return new HttpEntity<>(revolutHeaderBuilderService.getAuthorizedHeaders());
    }

    public HttpEntity<MultiValueMap<String, String>> getAccessTokenRequest() {

        MultiValueMap<String, String> body = revolutRequestBodyBuilderService.getAccessTokenRequestParams();
        HttpHeaders headers = revolutHeaderBuilderService.getHttpHeaders();
        return new HttpEntity<>(body, headers);
    }

    public HttpEntity<MultiValueMap<String, String>> getTransactionsRequest(String counterparty, Date from, Date to,
                                                                            Integer count) {

        MultiValueMap<String, String> body =
                revolutRequestBodyBuilderService.getTransactionsRequestParams(counterparty, from, to, count);
        HttpHeaders headers = revolutHeaderBuilderService.getAuthorizedHeaders();
        return new HttpEntity<>(body, headers);
    }

    public HttpEntity<String> getCounterpartyRequest(CounterpartyRequestBody body) {

        String requestBody = revolutRequestBodyBuilderService.getCounterpartyRequestBody(body);
        HttpHeaders headers = revolutHeaderBuilderService.getAuthorizedJsonHeaders();
        return new HttpEntity<>(requestBody, headers);
    }

    public HttpEntity<String> getCounterpartiesRequest() {

        return new HttpEntity<>(revolutHeaderBuilderService.getAuthorizedHeaders());
    }

    public HttpEntity<String> getTransferRequest(TransferRequestBody body) {

        String requestBody = revolutRequestBodyBuilderService.getTransferRequestBody(body);
        HttpHeaders headers = revolutHeaderBuilderService.getAuthorizedJsonHeaders();
        return new HttpEntity<>(requestBody, headers);
    }

    public HttpEntity<String> getPaymentRequest(CreatePaymentRequestBody body) {

        String requestBody = revolutRequestBodyBuilderService.getPaymentRequestBody(body);
        HttpHeaders headers = revolutHeaderBuilderService.getAuthorizedJsonHeaders();
        return new HttpEntity<>(requestBody, headers);
    }
}
