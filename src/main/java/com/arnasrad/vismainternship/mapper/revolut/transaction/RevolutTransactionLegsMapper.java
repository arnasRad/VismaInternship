package com.arnasrad.vismainternship.mapper.revolut.transaction;

import com.arnasrad.vismainternship.mapper.transaction.LegsCounterpartyMapper;
import com.arnasrad.vismainternship.model.dto.revolut.transaction.RevolutTransactionDTO;
import com.arnasrad.vismainternship.model.dto.revolut.transaction.RevolutTransactionLegsDTO;
import com.arnasrad.vismainternship.model.dto.transaction.LegsCounterpartyDTO;
import com.arnasrad.vismainternship.model.entity.revolut.transaction.RevolutTransaction;
import com.arnasrad.vismainternship.model.entity.revolut.transaction.RevolutTransactionLegs;
import com.arnasrad.vismainternship.model.entity.transaction.LegsCounterparty;

import java.util.ArrayList;
import java.util.List;


public class RevolutTransactionLegsMapper {

    private final LegsCounterpartyMapper legsCounterpartyMapper;
    private final RevolutTransactionMapper revolutTransactionMapper;

    public RevolutTransactionLegsMapper(LegsCounterpartyMapper legsCounterpartyMapper, RevolutTransactionMapper revolutTransactionMapper) {
        this.legsCounterpartyMapper = legsCounterpartyMapper;
        this.revolutTransactionMapper = revolutTransactionMapper;
    }

    public RevolutTransactionLegsDTO mapToDTO(RevolutTransactionLegs entity) {
        LegsCounterpartyDTO legsCounterpartyDTO = legsCounterpartyMapper.mapToDTO(entity.getCounterparty());
        RevolutTransactionDTO revolutTransactionDTO = revolutTransactionMapper.mapToDTO(entity.getRevolutTransaction());

        return new RevolutTransactionLegsDTO(entity.getAccountId(), entity.getBillAmount(), entity.getBillCurrency(),
                entity.getAccountId(), legsCounterpartyDTO, entity.getDescription(), entity.getBalance(),
                entity.getBillAmount(), entity.getBillCurrency(), revolutTransactionDTO);
    }

    public RevolutTransactionLegs mapToEntity(RevolutTransactionLegsDTO dto) {
        LegsCounterparty legsCounterparty = legsCounterpartyMapper.mapToEntity(dto.getCounterparty());
        RevolutTransaction revolutTransaction = revolutTransactionMapper.mapToEntity(dto.getRevolutTransaction());

        return new RevolutTransactionLegs(dto.getId(), dto.getBillAmount(), dto.getBillCurrency(),
                dto.getAccountId(), legsCounterparty, dto.getDescription(), dto.getBalance(), dto.getBillAmount(),
                dto.getBillCurrency(), revolutTransaction);
    }

    public List<RevolutTransactionLegsDTO> mapToDTOArray(List<RevolutTransactionLegs> revolutTransactionLegs) {
        List<RevolutTransactionLegsDTO> revolutTransactionLegsDTOS = new ArrayList<>();

        for (RevolutTransactionLegs revolutCounterpartyAccount : revolutTransactionLegs) {
            revolutTransactionLegsDTOS.add(mapToDTO(revolutCounterpartyAccount));
        }

        return revolutTransactionLegsDTOS;
    }

    public List<RevolutTransactionLegs> mapToEntityList(List<RevolutTransactionLegsDTO> revolutTransactionLegsDTOS) {
        List<RevolutTransactionLegs> revolutTransactionLegs = new ArrayList<>();

        for(RevolutTransactionLegsDTO revolutTransactionLegsDTO : revolutTransactionLegsDTOS) {
            revolutTransactionLegs.add(mapToEntity(revolutTransactionLegsDTO));
        }

        return revolutTransactionLegs;
    }
}
