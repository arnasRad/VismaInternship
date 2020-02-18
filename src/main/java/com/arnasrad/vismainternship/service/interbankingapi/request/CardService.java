package com.arnasrad.vismainternship.service.interbankingapi.request;

import com.arnasrad.vismainternship.model.interbankingapi.card.Card;

import java.util.List;

public interface CardService {

    List<? extends Card> getCards();
}
