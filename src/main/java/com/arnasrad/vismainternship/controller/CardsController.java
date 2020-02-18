package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.model.card.Card;
import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.factory.CardServiceFactory;
import com.arnasrad.vismainternship.service.processor.OptionalValueProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("interbanking-cards-controller")
public class CardsController {

    private final OptionalValueProcessorService optionalValueProcessorService;
    private final CardServiceFactory accountFactory;

    @Autowired
    public CardsController(OptionalValueProcessorService optionalValueProcessorService, CardServiceFactory accountFactory) {
        this.optionalValueProcessorService = optionalValueProcessorService;
        this.accountFactory = accountFactory;
    }

    @GetMapping("/interbanking/cards")
    public List<? extends Card> getCards(@RequestParam String bank) throws BadRequestException, NoSuchFunctionalityException {

        return accountFactory.getService(optionalValueProcessorService.getRequestParameterValue("bank", bank)).getCards();
    }
}
