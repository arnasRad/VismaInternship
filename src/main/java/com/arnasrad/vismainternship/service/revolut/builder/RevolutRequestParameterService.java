package com.arnasrad.vismainternship.service.revolut.builder;

import com.arnasrad.vismainternship.service.dates.DatesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Date;

@Service
public class RevolutRequestParameterService {

    private final DatesService datesService;
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

    public RevolutRequestParameterService(DatesService datesService) {
        this.datesService = datesService;
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
        params.add("from", datesService.getDateString(from));
        params.add("to", datesService.getDateString(to));
        params.add("count", String.valueOf(count));

        return params;
    }
}
