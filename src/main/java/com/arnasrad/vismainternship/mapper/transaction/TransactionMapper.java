package com.arnasrad.vismainternship.mapper.transaction;

import com.arnasrad.vismainternship.model.dto.transaction.TransactionDTO;
import com.arnasrad.vismainternship.model.entity.transaction.Transaction;


public class TransactionMapper {

    public TransactionDTO mapToDTO(Transaction entity) {
        return new TransactionDTO(entity.getTransactionId(), entity.getType(), entity.getState(),
                entity.getCreatedAt(), entity.getCompletedAt(), entity.getReference());
    }

    public Transaction mapToEntity(TransactionDTO dto) {
        return new Transaction(dto.getId(), dto.getType(), dto.getState(), dto.getCreatedAt(), dto.getCompletedAt(),
                dto.getReference());
    }
}
