package com.arnasrad.vismainternship.mapper.revolut.counterparty;

import com.arnasrad.vismainternship.model.dto.revolut.counterparty.RevolutCounterpartyAccountDTO;
import com.arnasrad.vismainternship.model.dto.revolut.counterparty.RevolutCounterpartyDTO;
import com.arnasrad.vismainternship.model.entity.counterparty.Counterparty;
import com.arnasrad.vismainternship.model.entity.counterparty.CounterpartyAccount;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RevolutCounterpartyMapper {

    private final RevolutCounterpartyAccountMapper revolutCounterpartyAccountMapper;

    public RevolutCounterpartyMapper(RevolutCounterpartyAccountMapper revolutCounterpartyAccountMapper) {
        this.revolutCounterpartyAccountMapper = revolutCounterpartyAccountMapper;
    }

    public RevolutCounterpartyDTO mapToDTO(Counterparty entity) {
        List<RevolutCounterpartyAccountDTO> revolutCounterpartyAccountDTOS =
                revolutCounterpartyAccountMapper.mapToDTOArray(entity.getAccounts());

        return new RevolutCounterpartyDTO(entity.getCountry(), entity.getCounterpartyId(), entity.getName(),
                entity.getPhone(), revolutCounterpartyAccountDTOS, entity.getProfileType(), entity.getState(),
                entity.getCreatedAt(), entity.getUpdatedAt());
    }

    public Counterparty mapToEntity(RevolutCounterpartyDTO dto) {
        List<CounterpartyAccount> counterpartyAccounts =
                revolutCounterpartyAccountMapper.mapToEntityList(dto.getRevolutAccounts());

        return new Counterparty(dto.getId(), dto.getCountry(), dto.getName(), dto.getPhone(),
                counterpartyAccounts, dto.getProfileType(), dto.getState(), dto.getCreatedAt(), dto.getUpdatedAt());
    }
}
