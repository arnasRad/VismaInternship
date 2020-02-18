package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import com.arnasrad.vismainternship.component.JsonMapper;
import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.model.dnb.openbankingapi.card.DNBCard;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.service.dnb.openbankingapi.builder.DnbRequestBuilderService;
import com.arnasrad.vismainternship.service.request.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class DNBCardService implements CardService {

    @Value("${dnb.openbanking.endpoint.cards}")
    private String cardsEndpoint;

    private final RestTemplate restTemplate;
    private final DnbRequestBuilderService dnbRequestBuilderService;
    private final JsonMapper jsonMapper;

    @Autowired
    public DNBCardService(RestTemplate restTemplate, DnbRequestBuilderService dnbRequestBuilderService,
                          JsonMapper jsonMapper) {

        this.restTemplate = restTemplate;
        this.dnbRequestBuilderService = dnbRequestBuilderService;
        this.jsonMapper = jsonMapper;
    }

    @Override
    public List<DNBCard> getCards() throws BadRequestException {
        String jsonResponse = Optional.ofNullable(restTemplate.exchange(cardsEndpoint, HttpMethod.GET,
                dnbRequestBuilderService.getAuthorizedRequest(), String.class).getBody())
                .orElseThrow(() -> new BadRequestException(String.format(ErrorMessages.BAD_REQUEST, "getCards")));

        return jsonMapper.getObjectListFromString(jsonResponse, DNBCard.class);
    }

    @Override
    public String getBankId() {

        return BankId.DNB_ID.getBank();
    }
}
