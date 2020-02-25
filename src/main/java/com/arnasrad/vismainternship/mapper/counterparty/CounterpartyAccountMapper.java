package com.arnasrad.vismainternship.mapper.counterparty;

import com.arnasrad.vismainternship.model.dto.counterparty.CounterpartyAccountDTO;
import com.arnasrad.vismainternship.model.entity.counterparty.CounterpartyAccount;

import java.util.ArrayList;
import java.util.List;

public class CounterpartyAccountMapper {

    public CounterpartyAccountDTO mapToDTO(CounterpartyAccount entity) {
        return new CounterpartyAccountDTO(entity.getCounterpartyAccountId(), entity.getCurrency(), entity.getType(),
                entity.getAccountNo());
    }

    public CounterpartyAccount mapToEntity(CounterpartyAccountDTO dto) {
        return new CounterpartyAccount(dto.getId(), dto.getCurrency(), dto.getType(), dto.getAccountNo());
    }

    public List<CounterpartyAccountDTO> mapToDTOArray(List<CounterpartyAccount> counterpartyAccounts) {
        List<CounterpartyAccountDTO> counterpartyAccountDTOS = new ArrayList<>();

        for (CounterpartyAccount counterpartyAccount : counterpartyAccounts) {
            counterpartyAccountDTOS.add(mapToDTO(counterpartyAccount));
        }

        return counterpartyAccountDTOS;
    }

    public List<CounterpartyAccount> mapToEntityList(List<CounterpartyAccountDTO> counterpartyAccountDTOS) {
        List<CounterpartyAccount> counterpartyAccounts = new ArrayList<>();

        for(CounterpartyAccountDTO counterpartyAccountDTO : counterpartyAccountDTOS) {
            counterpartyAccounts.add(mapToEntity(counterpartyAccountDTO));
        }

        return counterpartyAccounts;
    }
}
