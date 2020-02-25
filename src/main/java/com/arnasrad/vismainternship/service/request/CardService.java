package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.dto.card.CardDTO;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

import java.util.List;

public interface CardService {

    List<? extends CardDTO> getCards() throws NoSuchFunctionalityException;

    String getBankId();
}
