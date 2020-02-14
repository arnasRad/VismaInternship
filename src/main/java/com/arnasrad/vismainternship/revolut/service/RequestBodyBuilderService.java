package com.arnasrad.vismainternship.revolut.service;

import com.arnasrad.vismainternship.component.IdGenerator;
import com.arnasrad.vismainternship.component.JsonMapper;
import com.arnasrad.vismainternship.revolut.model.requestbody.CounterpartyRequestBody;
import com.arnasrad.vismainternship.revolut.model.requestbody.CreatePaymentRequestBody;
import com.arnasrad.vismainternship.revolut.model.requestbody.TransferRequestBody;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service("revolut-request-body-builder")
public class RequestBodyBuilderService {

    @Value("${revolut.sandbox.constant.grantType}")
    private String grantType;

    @Value("${revolut.sandbox.constant.jwtToken}")
    private String jwtToken;

    @Value("${revolut.sandbox.constant.refreshToken}")
    private String refreshTokenConstant;

    @Value("${revolut.sandbox.constant.clientId}")
    private String clientId;

    @Value("${revolut.sandbox.constant.clientAssertionType}")
    private String clientAssertionType;

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private JsonMapper jsonMapper;

    private final Logger logger = LoggerFactory.getLogger(RequestBodyBuilderService.class);

    public MultiValueMap<String, String> getJwtRequestBody() {

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", grantType);
        body.add("refresh_token", refreshTokenConstant);
        body.add("client_id", clientId);
        body.add("client_assertion_type", clientAssertionType);
        body.add("client_assertion", jwtToken);

        return body;
    }

    public String getCounterpartyRequestBody(CounterpartyRequestBody counterpartyBody) {

        JSONObject body = new JSONObject();

        body.put("profile_type", counterpartyBody.getProfileType());
        body.put("name", counterpartyBody.getName());
        body.put("phone", counterpartyBody.getPhone());
        body.put("email", counterpartyBody.getEmail());

        return body.toString();
    }

    public String getTransferRequestBody(TransferRequestBody transferRequestBody) {

        JSONObject body = new JSONObject();
        body.put("request_id", idGenerator.generateRequestId());
        body.put("source_account_id", transferRequestBody.getSourceAccountId());
        body.put("target_account_id", transferRequestBody.getTargetAccountId());
        body.put("amount", transferRequestBody.getAmount());
        body.put("currency", transferRequestBody.getCurrency());
        body.put("description", transferRequestBody.getDescription());

        return body.toString();
    }
    public String getPaymentRequestBody(CreatePaymentRequestBody createPaymentRequestBody) {

        createPaymentRequestBody.setRequestId(idGenerator.generateRequestId());
        return jsonMapper.getStringFromObject(createPaymentRequestBody);
    }
}
