package com.arnasrad.vismainternship.service.dnb.builder;

import com.arnasrad.vismainternship.model.dto.dnb.payment.DnbPaymentRequestDto;
import com.arnasrad.vismainternship.model.dto.dnb.token.DnbConsentRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class DnbPsd2RequestBuilderService {

    private final DnbPsd2HeaderBuilderService dnbPsd2HeaderBuilderService;
    private final DnbPsd2RequestBodyBuilderService dnbPsd2RequestBodyBuilderService;

    public DnbPsd2RequestBuilderService(DnbPsd2HeaderBuilderService dnbPsd2HeaderBuilderService, DnbPsd2RequestBodyBuilderService dnbPsd2RequestBodyBuilderService) {
        this.dnbPsd2HeaderBuilderService = dnbPsd2HeaderBuilderService;
        this.dnbPsd2RequestBodyBuilderService = dnbPsd2RequestBodyBuilderService;
    }

    public HttpEntity<String> getRequest() {
        return new HttpEntity<>(dnbPsd2HeaderBuilderService.getHttpHeaders());
    }

    public HttpEntity<String> getConsentRequest(DnbConsentRequestDto consentRequestDto) throws JsonProcessingException {
        HttpHeaders headers = dnbPsd2HeaderBuilderService.getHttpHeaders();
        String body = dnbPsd2RequestBodyBuilderService.getConsentRequestBody(consentRequestDto);
        return new HttpEntity<>(body, headers);
    }

    public HttpEntity<String> getAuthorizedRequest() {
        return new HttpEntity<>(dnbPsd2HeaderBuilderService.getAuthorizedHttpHeaders());
    }

    public HttpEntity<DnbPaymentRequestDto> getAuthorizedRequest(DnbPaymentRequestDto requestDto) {
        return new HttpEntity<>(requestDto, dnbPsd2HeaderBuilderService.getAuthorizedHttpHeaders());
    }

    public HttpEntity<String> getRequestWithSSN() {
        return new HttpEntity<>(dnbPsd2RequestBodyBuilderService.getBodyForRequestWithSSN(),
                dnbPsd2HeaderBuilderService.getHttpHeaders());
    }


}
