package com.arnasrad.vismainternship.mapper.revolut.transaction;

import com.arnasrad.vismainternship.model.dto.revolut.transaction.TransactionCardDTO;
import com.arnasrad.vismainternship.model.entity.transaction.TransactionCard;
import org.springframework.stereotype.Component;

@Component
public class TransactionCardMapper {

    public TransactionCardDTO mapToDTO(TransactionCard entity) {
        if (entity == null) {
            return null;
        }

        return new TransactionCardDTO(entity.getCardNumber(), entity.getFirstName(), entity.getLastName(),
                entity.getPhone());
    }

    public TransactionCard mapToEntity(TransactionCardDTO dto) {
        if (dto == null) {
            return null;
        }

        return new TransactionCard(dto.getCardNumber(), dto.getFirstName(), dto.getLastName(), dto.getPhone());
    }
}
