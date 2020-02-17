package com.arnasrad.vismainternship.controller.dnb;

import com.arnasrad.vismainternship.model.dnb.openbankingapi.card.Card;
import com.arnasrad.vismainternship.service.dnb.openbankingapi.DNBRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    private final DNBRequestService DnbRequestService;

    @Autowired
    public CardsController(DNBRequestService dnbRequestService) {
        DnbRequestService = dnbRequestService;
    }

    @GetMapping("/dnb/cards")
    public List<Card> getCards() {

        return DnbRequestService.getCards();
    }
}
