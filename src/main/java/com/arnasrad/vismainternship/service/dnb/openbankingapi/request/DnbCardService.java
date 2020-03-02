package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.card.DnbCardDto;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.service.dnb.openbankingapi.builder.DnbRequestBuilderService;
import com.arnasrad.vismainternship.service.request.CardService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DnbCardService implements CardService {

    private final RestTemplate restTemplate;
    private final DnbRequestBuilderService dnbRequestBuilderService;
    @Value("${dnb.openbanking.endpoint.cards}")
    private String cardsEndpoint;

    public DnbCardService(RestTemplate restTemplate, DnbRequestBuilderService dnbRequestBuilderService) {
        this.restTemplate = restTemplate;
        this.dnbRequestBuilderService = dnbRequestBuilderService;
    }

    @Override
    public List<DnbCardDto> getCards() {
        HttpEntity<String> authorizedHttpEntity = dnbRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<List<DnbCardDto>> responseEntity = restTemplate.exchange(cardsEndpoint, HttpMethod.GET,
                authorizedHttpEntity, new ParameterizedTypeReference<List<DnbCardDto>>() {
                });

        return responseEntity.getBody();
    }

    public void setCardsEndpoint(String cardsEndpoint) {
        this.cardsEndpoint = cardsEndpoint;
    }

    @Override
    public String getBankId() {
        return BankId.DNB_ID.getBank();
    }
}