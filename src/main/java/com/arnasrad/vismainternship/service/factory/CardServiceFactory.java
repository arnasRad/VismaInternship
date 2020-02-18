package com.arnasrad.vismainternship.service.factory;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.service.request.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CardServiceFactory {

    private List<CardService> cardServiceList;

    @Autowired
    public CardServiceFactory(List<CardService> cardServiceList) {
        this.cardServiceList = cardServiceList;
    }

    public CardService getService(String bank) {

        return cardServiceList.stream()
                .filter(cardService -> cardService.getBankId().equals(bank))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(ErrorMessages.WRONG_BANK));
    }
}
