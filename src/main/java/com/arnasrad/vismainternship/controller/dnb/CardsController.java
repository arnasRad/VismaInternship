package com.arnasrad.vismainternship.controller.dnb;

import com.arnasrad.vismainternship.model.dnb.openbankingapi.card.DNBCard;
import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.service.dnb.openbankingapi.request.DNBCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    private final DNBCardService dnbCardService;

    @Autowired
    public CardsController(DNBCardService dnbCardService) {
        this.dnbCardService = dnbCardService;
    }

    @GetMapping("/dnb/cards")
    public List<DNBCard> getCards() throws BadRequestException {

        return dnbCardService.getCards();
    }
}
