package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.dto.CardDto;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

import java.util.List;

public interface CardService {

    List<CardDto> getCards() throws NoSuchFunctionalityException;

    String getBankId();
}
