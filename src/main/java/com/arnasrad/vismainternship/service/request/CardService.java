package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.Card;

import java.util.List;

public interface CardService {

    List<? extends Card> getCards();
}
