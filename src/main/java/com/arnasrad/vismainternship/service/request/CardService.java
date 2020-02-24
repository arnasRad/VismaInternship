package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.card.Card;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

import java.util.List;

public interface CardService {

    List<? extends Card> getCards() throws NoSuchFunctionalityException;

    String getBankId();
}
