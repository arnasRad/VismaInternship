package com.arnasrad.vismainternship.mapper.revolut.transaction;

import com.arnasrad.vismainternship.mapper.transaction.LegsCounterpartyMapper;
import com.arnasrad.vismainternship.model.dto.revolut.transaction.RevolutTransactionLegsDTO;
import com.arnasrad.vismainternship.model.dto.transaction.LegsCounterpartyDTO;
import com.arnasrad.vismainternship.model.entity.transaction.LegsCounterparty;
import com.arnasrad.vismainternship.model.entity.transaction.TransactionLegs;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RevolutTransactionLegsMapper {

    private final LegsCounterpartyMapper legsCounterpartyMapper;

    public RevolutTransactionLegsMapper(LegsCounterpartyMapper legsCounterpartyMapper) {
        this.legsCounterpartyMapper = legsCounterpartyMapper;
    }

    public RevolutTransactionLegsDTO mapToDTO(TransactionLegs entity) {
        LegsCounterpartyDTO legsCounterpartyDTO = legsCounterpartyMapper.mapToDTO(entity.getCounterparty());

        return new RevolutTransactionLegsDTO(entity.getAccountId(), entity.getBillAmount(), entity.getBillCurrency(),
                entity.getAccountId(), legsCounterpartyDTO, entity.getDescription(), entity.getBalance(),
                entity.getBillAmount(), entity.getBillCurrency());
    }

    public TransactionLegs mapToEntity(RevolutTransactionLegsDTO dto) {
        LegsCounterparty legsCounterparty = legsCounterpartyMapper.mapToEntity(dto.getCounterparty());

        return new TransactionLegs(dto.getId(), dto.getAmount(), dto.getCurrency(), dto.getAccountId(),
                legsCounterparty, dto.getDescription(), dto.getBalance(), dto.getBillAmount(), dto.getBillCurrency());
    }

    public List<RevolutTransactionLegsDTO> mapToDTOArray(List<TransactionLegs> revolutTransactionLegs) {
        List<RevolutTransactionLegsDTO> revolutTransactionLegsDTOS = new ArrayList<>();

        for (TransactionLegs revolutCounterpartyAccount : revolutTransactionLegs) {
            revolutTransactionLegsDTOS.add(mapToDTO(revolutCounterpartyAccount));
        }

        return revolutTransactionLegsDTOS;
    }

    public List<TransactionLegs> mapToEntityList(List<RevolutTransactionLegsDTO> revolutTransactionLegsDTOS) {
        List<TransactionLegs> revolutTransactionLegs = new ArrayList<>();

        for(RevolutTransactionLegsDTO revolutTransactionLegsDTO : revolutTransactionLegsDTOS) {
            revolutTransactionLegs.add(mapToEntity(revolutTransactionLegsDTO));
        }

        return revolutTransactionLegs;
    }
}
