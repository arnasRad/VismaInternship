package com.arnasrad.vismainternship.mapper.transaction;

import com.arnasrad.vismainternship.model.dto.transaction.TransactionCardDTO;
import com.arnasrad.vismainternship.model.entity.transaction.TransactionCard;


public class TransactionCardMapper {

    public TransactionCardDTO mapToDTO(TransactionCard entity) {
        return new TransactionCardDTO(entity.getCardNumber(), entity.getFirstName(), entity.getLastName(),
                entity.getPhone());
    }

    public TransactionCard mapToEntity(TransactionCardDTO dto) {
        return new TransactionCard(dto.getCardNumber(), dto.getFirstName(), dto.getLastName(), dto.getPhone());
    }
}
