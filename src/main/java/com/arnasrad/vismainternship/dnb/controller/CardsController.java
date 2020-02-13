package com.arnasrad.vismainternship.dnb.controller;

import com.arnasrad.vismainternship.dnb.openbanking.model.card.Card;
import com.arnasrad.vismainternship.dnb.openbanking.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    @Qualifier("dnb-request-service")
    private RequestService requestService;

    @GetMapping("/dnb/cards")
    public List<Card> getCards() {

        return requestService.getCards();
    }
}
