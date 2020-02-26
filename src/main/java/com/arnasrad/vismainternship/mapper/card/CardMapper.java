package com.arnasrad.vismainternship.mapper.card;

import com.arnasrad.vismainternship.model.dto.card.CardDTO;
import com.arnasrad.vismainternship.model.entity.card.Card;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    public CardDTO mapToDTO(Card entity) {
        return new CardDTO(entity.getCustomerId(), entity.getCardId(), entity.getAccountNumber(),
                entity.getCreditBalance(), entity.getDebitBalance(), entity.getCardType(), entity.getProductName());
    }

    public Card mapToEntity(CardDTO dto) {
        return new Card(dto.getCardId(), dto.getCustomerId(), dto.getAccountNumber(), dto.getCreditBalance(),
                dto.getDebitBalance(), dto.getCardType(), dto.getProductName(), null, null, null, null, null, null);
    }
}
