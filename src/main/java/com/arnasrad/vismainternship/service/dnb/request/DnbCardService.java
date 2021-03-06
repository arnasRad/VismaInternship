package com.arnasrad.vismainternship.service.dnb.request;

import com.arnasrad.vismainternship.mapper.dnb.DnbCardMapper;
import com.arnasrad.vismainternship.model.dto.CardDto;
import com.arnasrad.vismainternship.model.dto.dnb.card.DnbCardDto;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.service.dnb.builder.DnbRequestBuilderService;
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
    private final DnbCardMapper dnbCardMapper;
    @Value("${dnb.openbanking.endpoint.cards}")
    private String cardsEndpoint;

    public DnbCardService(RestTemplate restTemplate, DnbRequestBuilderService dnbRequestBuilderService, DnbCardMapper dnbCardMapper) {
        this.restTemplate = restTemplate;
        this.dnbRequestBuilderService = dnbRequestBuilderService;
        this.dnbCardMapper = dnbCardMapper;
    }

    @Override
    public List<CardDto> getCards() {
        HttpEntity<String> authorizedHttpEntity = dnbRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<List<DnbCardDto>> responseEntity = restTemplate.exchange(cardsEndpoint, HttpMethod.GET,
                authorizedHttpEntity, new ParameterizedTypeReference<List<DnbCardDto>>() {
                });

        List<DnbCardDto> dnbCardDtoList = responseEntity.getBody();
        return dnbCardMapper.mapToCardDtoList(dnbCardDtoList);
    }

    public void setCardsEndpoint(String cardsEndpoint) {
        this.cardsEndpoint = cardsEndpoint;
    }

    @Override
    public String getBankId() {
        return BankId.DNB_ID.getBank();
    }
}
