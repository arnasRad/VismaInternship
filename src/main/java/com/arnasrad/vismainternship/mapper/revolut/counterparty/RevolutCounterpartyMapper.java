package com.arnasrad.vismainternship.mapper.revolut.counterparty;

import com.arnasrad.vismainternship.model.dto.revolut.counterparty.RevolutCounterpartyAccountDTO;
import com.arnasrad.vismainternship.model.dto.revolut.counterparty.RevolutCounterpartyDTO;
import com.arnasrad.vismainternship.model.entity.revolut.counterparty.RevolutCounterparty;
import com.arnasrad.vismainternship.model.entity.revolut.counterparty.RevolutCounterpartyAccount;

import java.util.List;


public class RevolutCounterpartyMapper {

    private final RevolutCounterpartyAccountMapper revolutCounterpartyAccountMapper;

    public RevolutCounterpartyMapper(RevolutCounterpartyAccountMapper revolutCounterpartyAccountMapper) {
        this.revolutCounterpartyAccountMapper = revolutCounterpartyAccountMapper;
    }

    public RevolutCounterpartyDTO mapToDTO(RevolutCounterparty entity) {
        List<RevolutCounterpartyAccountDTO> revolutCounterpartyAccountDTOS =
                revolutCounterpartyAccountMapper.mapToDTOArray(entity.getRevolutAccounts());

        return new RevolutCounterpartyDTO(entity.getCountry(), entity.getCounterpartyId(), entity.getName(),
                entity.getPhone(), revolutCounterpartyAccountDTOS, entity.getProfileType(), entity.getState(),
                entity.getCreatedAt(), entity.getUpdatedAt());
    }

    public RevolutCounterparty mapToEntity(RevolutCounterpartyDTO dto) {
        List<RevolutCounterpartyAccount> revolutCounterpartyAccounts =
                revolutCounterpartyAccountMapper.mapToEntityList(dto.getRevolutAccounts());

        return new RevolutCounterparty(dto.getCountry(), dto.getId(), dto.getName(), dto.getPhone(),
                revolutCounterpartyAccounts, dto.getProfileType(), dto.getState(), dto.getCreatedAt(), dto.getUpdatedAt());
    }
}
