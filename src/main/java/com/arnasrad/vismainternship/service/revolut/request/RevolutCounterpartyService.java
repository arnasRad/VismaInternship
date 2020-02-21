package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.revolut.counterparty.RevolutCounterparty;
import com.arnasrad.vismainternship.model.revolut.requestbody.CounterpartyRequestBody;
import com.arnasrad.vismainternship.service.mapping.JsonMapperService;
import com.arnasrad.vismainternship.service.request.CounterpartyService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RevolutCounterpartyService implements CounterpartyService {

    @Value("${revolut.endpoint.counterparty}")
    private String counterpartyEndpoint;

    @Value("${revolut.endpoint.counterparties}")
    private String counterpartiesEndpoint;

    private final RestTemplate restTemplate;
    private final RevolutRequestBuilderService revolutRequestBuilderService;
    private final JsonMapperService jsonMapperService;

    @Autowired
    public RevolutCounterpartyService(RestTemplate restTemplate, RevolutRequestBuilderService revolutRequestBuilderService, JsonMapperService jsonMapperService) {

        this.restTemplate = restTemplate;
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.jsonMapperService = jsonMapperService;
    }

    @Override
    public RevolutCounterparty addCounterparty(CounterpartyRequestBody body) {

        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getCounterpartyRequest(body);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(counterpartyEndpoint,
                authorizedHttpEntity, String.class);

        String jsonResponse = responseEntity.getBody();

        return jsonMapperService.getObjectFromString(jsonResponse, RevolutCounterparty.class);
    }

    @Override
    public List<RevolutCounterparty> getCounterparties() {

        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getCounterpartiesRequest();

        ResponseEntity<String> responseEntity = restTemplate.exchange(counterpartiesEndpoint, HttpMethod.GET,
                authorizedHttpEntity, String.class);

        String jsonResponse = responseEntity.getBody();

        return jsonMapperService.getObjectListFromString(jsonResponse, RevolutCounterparty.class);
    }

    @Override
    public String getBankId() {

        return BankId.REVOLUT_ID.getBank();
    }
}
