package com.arnasrad.vismainternship.interbankingapi.controller;

import com.arnasrad.vismainternship.component.OptionalValueProcessor;
import com.arnasrad.vismainternship.interbankingapi.model.Card;
import com.arnasrad.vismainternship.interbankingapi.service.RequestMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController("interbanking-cards-controller")
public class CardsController {

    @Autowired
    private OptionalValueProcessor optionalValueProcessor;

    @Autowired
    private RequestMappingService requestMappingService;

    @GetMapping("/interbanking/cards")
    public Map<String, List<Card>> getCards(String bank) {

        return requestMappingService.mapCardsRequest(optionalValueProcessor.getOptionalRequestParameterValue(
                "bank", bank));
    }
}
