package com.arnasrad.vismainternship.service.dnb.builder;

import com.arnasrad.vismainternship.model.dto.token.DnbConsentRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DnbPsd2RequestBodyBuilderService {

    @Value("${dnb.psd2.ssn1}")
    private String ssn;
    private final ObjectMapper objectMapper;

    public DnbPsd2RequestBodyBuilderService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String getBodyForRequestWithSSN() {
        JSONObject body = new JSONObject();
        body.put("ssn", ssn);

        return body.toString();
    }

    public String getConsentRequestBody(DnbConsentRequestDto consentRequestDto) throws JsonProcessingException {
        return objectMapper.writeValueAsString(consentRequestDto);
    }
}
