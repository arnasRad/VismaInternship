package com.arnasrad.vismainternship.mapper.card;

import com.arnasrad.vismainternship.model.dto.card.CardDTO;
import com.arnasrad.vismainternship.model.entity.card.Card;

public class CardMapper {

    public CardDTO mapToDTO(Card entity) {
        return new CardDTO(entity.getCustomerId(), entity.getCardId(), entity.getAccountNumber(),
                entity.getCreditBalance(), entity.getDebitBalance(), entity.getCardType(), entity.getProductName());
    }

    public Card mapToEntity(CardDTO dto) {
        return new Card(dto.getCustomerId(), dto.getCardId(), dto.getAccountNumber(), dto.getCreditBalance(),
                dto.getDebitBalance(), dto.getCardType(), dto.getProductName());
    }
}
