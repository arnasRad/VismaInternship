package com.arnasrad.vismainternship.service.revolut.builder;

import com.arnasrad.vismainternship.component.Dates;
import com.arnasrad.vismainternship.component.IdGenerator;
import com.arnasrad.vismainternship.component.JsonMapper;
import com.arnasrad.vismainternship.model.revolut.requestbody.CounterpartyRequestBody;
import com.arnasrad.vismainternship.model.revolut.requestbody.CreatePaymentRequestBody;
import com.arnasrad.vismainternship.model.revolut.requestbody.TransferRequestBody;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Date;

@Service
public class RevolutRequestBodyBuilderService {

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

    private final IdGenerator idGenerator;
    private final JsonMapper jsonMapper;
    private final Dates dates;

    @Autowired
    public RevolutRequestBodyBuilderService(IdGenerator idGenerator, JsonMapper jsonMapper, Dates dates) {

        this.idGenerator = idGenerator;
        this.jsonMapper = jsonMapper;
        this.dates = dates;
    }

    public MultiValueMap<String, String> getAccessTokenRequestParams() {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", grantType);
        params.add("refresh_token", refreshTokenConstant);
        params.add("client_id", clientId);
        params.add("client_assertion_type", clientAssertionType);
        params.add("client_assertion", jwtToken);

        return params;
    }

    public MultiValueMap<String, String> getTransactionsRequestParams(String counterparty, Date from, Date to,
                                                                      Integer count) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("counterparty", counterparty);
        params.add("from", dates.getDateString(from));
        params.add("to", dates.getDateString(to));
        params.add("count", String.valueOf(count));

        return params;
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
