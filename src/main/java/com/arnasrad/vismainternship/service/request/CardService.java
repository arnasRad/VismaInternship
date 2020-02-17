package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.dnb.openbankingapi.card.Card;

import java.util.List;

public interface CardService {

    List<Card> getCards();
}
