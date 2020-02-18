package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.component.JsonMapper;
import com.arnasrad.vismainternship.model.revolut.counterparty.RevolutCounterparty;
import com.arnasrad.vismainternship.model.revolut.requestbody.CounterpartyRequestBody;
import com.arnasrad.vismainternship.service.interbankingapi.ResponseStatusExceptionBuilderService;
import com.arnasrad.vismainternship.service.interbankingapi.request.CounterpartyService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class RevolutCounterpartyService implements CounterpartyService {

    @Value("${revolut.endpoint.counterparty}")
    private String counterpartyEndpoint;

    @Value("${revolut.endpoint.counterparties}")
    private String counterpartiesEndpoint;

    @Value("${constant.revolut-id-uppercase}")
    private String revolutId;

    private final RestTemplate restTemplate;
    private final RevolutRequestBuilderService revolutRequestBuilderService;
    private final JsonMapper jsonMapper;
    private final ResponseStatusExceptionBuilderService exceptionBuilder;

    @Autowired
    public RevolutCounterpartyService(RestTemplate restTemplate, RevolutRequestBuilderService revolutRequestBuilderService, JsonMapper jsonMapper, ResponseStatusExceptionBuilderService exceptionBuilder) {

        this.restTemplate = restTemplate;
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.jsonMapper = jsonMapper;
        this.exceptionBuilder = exceptionBuilder;
    }

    @Override
    public RevolutCounterparty addCounterparty(CounterpartyRequestBody body) {

        String jsonResponse = Optional.ofNullable(restTemplate.postForEntity(counterpartyEndpoint,
                revolutRequestBuilderService.getCounterpartyRequest(body), String.class).getBody())
                .orElseThrow(() -> exceptionBuilder.getException400("add-counterparty"));

        return jsonMapper.getObjectFromString(jsonResponse, RevolutCounterparty.class);
    }

    @Override
    public List<RevolutCounterparty> getCounterparties() {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(counterpartiesEndpoint, HttpMethod.GET,
                revolutRequestBuilderService.getCounterpartiesRequest(), String.class).getBody())
                .orElseThrow(() -> exceptionBuilder.getException400("get-counterparties"));

        return jsonMapper.getObjectListFromString(jsonResponse, RevolutCounterparty.class);
    }
}
