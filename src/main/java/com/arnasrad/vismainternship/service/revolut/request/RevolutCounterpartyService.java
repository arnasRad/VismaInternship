package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.mapper.revolut.RevolutCounterpartyMapper;
import com.arnasrad.vismainternship.model.dto.CounterpartyDto;
import com.arnasrad.vismainternship.model.dto.revolut.counterparty.RevolutCounterpartyDto;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.service.request.CounterpartyService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RevolutCounterpartyService implements CounterpartyService {

    private final RestTemplate restTemplate;
    private final RevolutRequestBuilderService revolutRequestBuilderService;
    private final RevolutCounterpartyMapper revolutCounterpartyMapper;
    @Value("${revolut.endpoint.counterparty}")
    private String counterpartyEndpoint;
    @Value("${revolut.endpoint.counterparties}")
    private String counterpartiesEndpoint;
    @Value("${revolut.endpoint.delete-counterparty}")
    private String deleteCounterpartyEndpoint;

    public RevolutCounterpartyService(RestTemplate restTemplate, RevolutRequestBuilderService revolutRequestBuilderService, RevolutCounterpartyMapper revolutCounterpartyMapper) {
        this.restTemplate = restTemplate;
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.revolutCounterpartyMapper = revolutCounterpartyMapper;
    }

    @Override
    public CounterpartyDto addCounterparty(String body) {
        JSONObject jsonObject = new JSONObject(body);
        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getAuthorizedJsonRequestWithBody(jsonObject);

        ResponseEntity<RevolutCounterpartyDto> responseEntity = restTemplate.postForEntity(counterpartyEndpoint,
                authorizedHttpEntity, RevolutCounterpartyDto.class);

        RevolutCounterpartyDto counterpartyDto = responseEntity.getBody();

        return revolutCounterpartyMapper.mapToCounterpartyDto(counterpartyDto);
    }

    @Override
    public List<CounterpartyDto> getCounterparties() {
        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<List<RevolutCounterpartyDto>> responseEntity = restTemplate.exchange(counterpartiesEndpoint,
                HttpMethod.GET, authorizedHttpEntity,
                new ParameterizedTypeReference<List<RevolutCounterpartyDto>>() {
                });

        List<RevolutCounterpartyDto> revolutCounterpartyDtoList = responseEntity.getBody();
        return revolutCounterpartyMapper.mapToCounterpartyDtoList(revolutCounterpartyDtoList);
    }

    @Override
    public String deleteCounterparty(String id) {
        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<String> response = restTemplate.exchange(deleteCounterpartyEndpoint.concat("/").concat(id),
                HttpMethod.DELETE, authorizedHttpEntity, String.class);

        return response.getBody();
    }

    public void setCounterpartyEndpoint(String counterpartyEndpoint) {
        this.counterpartyEndpoint = counterpartyEndpoint;
    }

    public void setCounterpartiesEndpoint(String counterpartiesEndpoint) {
        this.counterpartiesEndpoint = counterpartiesEndpoint;
    }

    public void setDeleteCounterpartyEndpoint(String deleteCounterpartyEndpoint) {
        this.deleteCounterpartyEndpoint = deleteCounterpartyEndpoint;
    }

    @Override
    public String getBankId() {
        return BankId.REVOLUT_ID.getBank();
    }
}
