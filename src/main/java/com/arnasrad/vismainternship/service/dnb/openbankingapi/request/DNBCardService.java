package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import com.arnasrad.vismainternship.model.dnb.openbankingapi.card.DNBCard;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.service.dnb.openbankingapi.builder.DnbRequestBuilderService;
import com.arnasrad.vismainternship.service.mapping.JsonMapperService;
import com.arnasrad.vismainternship.service.request.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DNBCardService implements CardService {

    @Value("${dnb.openbanking.endpoint.cards}")
    private String cardsEndpoint;

    private final RestTemplate restTemplate;
    private final DnbRequestBuilderService dnbRequestBuilderService;
    private final JsonMapperService jsonMapperService;

    @Autowired
    public DNBCardService(RestTemplate restTemplate, DnbRequestBuilderService dnbRequestBuilderService,
                          JsonMapperService jsonMapperService) {

        this.restTemplate = restTemplate;
        this.dnbRequestBuilderService = dnbRequestBuilderService;
        this.jsonMapperService = jsonMapperService;
    }

    @Override
    public List<DNBCard> getCards() {

        HttpEntity<String> authorizedHttpEntity = dnbRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<String> responseEntity = restTemplate.exchange(cardsEndpoint, HttpMethod.GET,
                authorizedHttpEntity, String.class);

        String jsonResponse = responseEntity.getBody();

        return jsonMapperService.getObjectListFromString(jsonResponse, DNBCard.class);
    }

    public void setCardsEndpoint(String cardsEndpoint) {
        this.cardsEndpoint = cardsEndpoint;
    }

    @Override
    public String getBankId() {

        return BankId.DNB_ID.getBank();
    }
}
