package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.component.JsonMapper;
import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.model.revolut.counterparty.RevolutCounterparty;
import com.arnasrad.vismainternship.model.revolut.requestbody.CounterpartyRequestBody;
import com.arnasrad.vismainternship.service.request.CounterpartyService;
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

    private final RestTemplate restTemplate;
    private final RevolutRequestBuilderService revolutRequestBuilderService;
    private final JsonMapper jsonMapper;

    @Autowired
    public RevolutCounterpartyService(RestTemplate restTemplate, RevolutRequestBuilderService revolutRequestBuilderService, JsonMapper jsonMapper) {

        this.restTemplate = restTemplate;
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.jsonMapper = jsonMapper;
    }

    @Override
    public RevolutCounterparty addCounterparty(CounterpartyRequestBody body) throws BadRequestException {

        String jsonResponse = Optional.ofNullable(restTemplate.postForEntity(counterpartyEndpoint,
                revolutRequestBuilderService.getCounterpartyRequest(body), String.class).getBody())
                .orElseThrow(() -> new BadRequestException(String.format(ErrorMessages.BAD_REQUEST,
                        "getCounterparty")));

        return jsonMapper.getObjectFromString(jsonResponse, RevolutCounterparty.class);
    }

    @Override
    public List<RevolutCounterparty> getCounterparties() throws BadRequestException {

        String jsonResponse = Optional.ofNullable(restTemplate.exchange(counterpartiesEndpoint, HttpMethod.GET,
                revolutRequestBuilderService.getCounterpartiesRequest(), String.class).getBody())
                .orElseThrow(() -> new BadRequestException(String.format(ErrorMessages.BAD_REQUEST,
                        "getCounterparties")));

        return jsonMapper.getObjectListFromString(jsonResponse, RevolutCounterparty.class);
    }

    @Override
    public String getBankId() {

        return BankId.REVOLUT_ID.getBank();
    }
}
