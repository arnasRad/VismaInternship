package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.component.OptionalValueProcessor;
import com.arnasrad.vismainternship.model.Card;
import com.arnasrad.vismainternship.service.factory.CardFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("interbanking-cards-controller")
public class CardsController {

    private final OptionalValueProcessor optionalValueProcessor;
    private final CardFactory accountFactory;

    @Autowired
    public CardsController(OptionalValueProcessor optionalValueProcessor, CardFactory accountFactory) {
        this.optionalValueProcessor = optionalValueProcessor;
        this.accountFactory = accountFactory;
    }

    @GetMapping("/interbanking/cards")
    public List<? extends Card> getCards(String bank) {

        return accountFactory.getService(optionalValueProcessor.getRequestParameterValue("bank", bank)).getCards();
    }
}
