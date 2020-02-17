package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.component.OptionalValueProcessor;
import com.arnasrad.vismainternship.model.Card;
import com.arnasrad.vismainternship.service.RequestMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController("interbanking-cards-controller")
public class CardsController {

    private final OptionalValueProcessor optionalValueProcessor;
    private final RequestMappingService requestMappingService;

    @Autowired
    public CardsController(OptionalValueProcessor optionalValueProcessor, RequestMappingService requestMappingService) {
        this.optionalValueProcessor = optionalValueProcessor;
        this.requestMappingService = requestMappingService;
    }

    @GetMapping("/interbanking/cards")
    public Map<String, List<Card>> getCards(String bank) {

        return null;
//        return requestMappingService.mapCardsRequest(optionalValueProcessor.getRequestParameterValue(
//                "bank", bank));
    }
}
