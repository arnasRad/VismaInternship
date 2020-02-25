package com.arnasrad.vismainternship.mapper.transaction;

import com.arnasrad.vismainternship.model.dto.transaction.LegsCounterpartyDTO;
import com.arnasrad.vismainternship.model.dto.transaction.TransactionLegsDTO;
import com.arnasrad.vismainternship.model.entity.transaction.LegsCounterparty;
import com.arnasrad.vismainternship.model.entity.transaction.TransactionLegs;


public class TransactionLegsMapper {

    private final LegsCounterpartyMapper legsCounterpartyMapper;

    public TransactionLegsMapper(LegsCounterpartyMapper legsCounterpartyMapper) {
        this.legsCounterpartyMapper = legsCounterpartyMapper;
    }

    public TransactionLegsDTO mapToDTO(TransactionLegs entity) {
        LegsCounterpartyDTO legsCounterpartyDTO = legsCounterpartyMapper.mapToDTO(entity.getCounterparty());

        return new TransactionLegsDTO(entity.getAccountId(), entity.getAmount(), entity.getCurrency(),
                entity.getAccountId(), legsCounterpartyDTO, entity.getDescription(), entity.getBalance());
    }

    public TransactionLegs mapToEntity(TransactionLegsDTO dto) {
        LegsCounterparty legsCounterparty = legsCounterpartyMapper.mapToEntity(dto.getCounterparty());

        return new TransactionLegs(dto.getId(), dto.getAmount(), dto.getCurrency(), dto.getAccountId(),
                legsCounterparty, dto.getDescription(), dto.getBalance());
    }
}
