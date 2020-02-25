package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.model.entity.card.Card;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.factory.CardServiceFactory;
import com.arnasrad.vismainternship.service.request.CardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("interbanking-cards-controller")
public class CardsController {
    private final CardServiceFactory cardServiceFactory;

    public CardsController(CardServiceFactory cardServiceFactory) {
        this.cardServiceFactory = cardServiceFactory;
    }

    @GetMapping("/interbanking/cards")
    public List<? extends Card> getCards(@RequestParam String bank)
            throws NoSuchFunctionalityException {
        CardService service = cardServiceFactory.getService(bank);
        return service.getCards();
    }
}
