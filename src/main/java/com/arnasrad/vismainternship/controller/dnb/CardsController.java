package com.arnasrad.vismainternship.controller.dnb;

import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.card.DNBCardDTO;
import com.arnasrad.vismainternship.service.dnb.openbankingapi.request.DNBCardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    private final DNBCardService dnbCardService;

    public CardsController(DNBCardService dnbCardService) {
        this.dnbCardService = dnbCardService;
    }

    @GetMapping("/dnb/cards")
    public List<DNBCardDTO> getCards() {
        return dnbCardService.getCards();
    }
}
