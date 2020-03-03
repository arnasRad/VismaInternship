package com.arnasrad.vismainternship.service.revolut.builder;

import com.arnasrad.vismainternship.model.dto.payment.PaymentRequestDto;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
public class RevolutRequestBuilderService {
    private final RevolutHeaderBuilderService revolutHeaderBuilderService;
    private final RevolutRequestBodyBuilderService revolutRequestBodyBuilderService;

    public RevolutRequestBuilderService(RevolutHeaderBuilderService revolutHeaderBuilderService,
                                        RevolutRequestBodyBuilderService revolutRequestBodyBuilderService) {
        this.revolutHeaderBuilderService = revolutHeaderBuilderService;
        this.revolutRequestBodyBuilderService = revolutRequestBodyBuilderService;
    }

    public HttpEntity<String> getAuthorizedRequest() {
        return new HttpEntity<>(revolutHeaderBuilderService.getAuthorizedHeaders());
    }

    public HttpEntity<String> getAuthorizedJsonRequestWithBody(JSONObject body) {
        String jsonBody = body.toString();
        HttpHeaders headers = revolutHeaderBuilderService.getAuthorizedJsonHeaders();
        return new HttpEntity<>(jsonBody, headers);
    }

    public HttpEntity<MultiValueMap<String, String>> getTokenRequest() {
        MultiValueMap<String, String> body = revolutRequestBodyBuilderService.getTokenRequestParams();
        HttpHeaders headers = revolutHeaderBuilderService.getHttpHeaders();
        return new HttpEntity<>(body, headers);
    }

    public HttpEntity<String> getPaymentRequest(PaymentRequestDto body) {
        JSONObject paymentRequestJson = revolutRequestBodyBuilderService.getPaymentRequestBody(body);

        return getAuthorizedJsonRequestWithBody(paymentRequestJson);
    }
}
