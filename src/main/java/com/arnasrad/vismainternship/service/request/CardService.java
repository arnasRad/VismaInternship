package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.dto.card.CardDto;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

import java.util.List;

public interface CardService {

    List<? extends CardDto> getCards() throws NoSuchFunctionalityException;

    String getBankId();
}
