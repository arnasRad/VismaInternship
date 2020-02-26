package com.arnasrad.vismainternship.mapper.revolut.counterparty;

import com.arnasrad.vismainternship.model.dto.revolut.counterparty.RevolutCounterpartyAccountDTO;
import com.arnasrad.vismainternship.model.entity.counterparty.CounterpartyAccount;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RevolutCounterpartyAccountMapper {

    public RevolutCounterpartyAccountDTO mapToDTO(CounterpartyAccount entity) {
        return new RevolutCounterpartyAccountDTO(entity.getCounterpartyAccountId(), entity.getCurrency(),
                entity.getType(), entity.getAccountNo(), entity.getIban(), entity.getSortCode(),
                entity.getRoutingNumber(), entity.getBic(), entity.getRecipientCharges());
    }

    public CounterpartyAccount mapToEntity(RevolutCounterpartyAccountDTO dto) {
        return new CounterpartyAccount(dto.getId(), dto.getCurrency(), dto.getType(), dto.getAccountNo(),
                dto.getIban(), dto.getSortCode(), dto.getRoutingNumber(), dto.getBic(), dto.getRecipientCharges());
    }

    public List<RevolutCounterpartyAccountDTO> mapToDTOArray(List<CounterpartyAccount> revolutCounterpartyAccounts) {
        List<RevolutCounterpartyAccountDTO> revolutCounterpartyAccountDTOS = new ArrayList<>();

        for (CounterpartyAccount revolutCounterpartyAccount : revolutCounterpartyAccounts) {
            revolutCounterpartyAccountDTOS.add(mapToDTO(revolutCounterpartyAccount));
        }

        return revolutCounterpartyAccountDTOS;
    }

    public List<CounterpartyAccount> mapToEntityList(List<RevolutCounterpartyAccountDTO> revolutCounterpartyAccountDTOS) {
        List<CounterpartyAccount> revolutCounterpartyAccounts = new ArrayList<>();

        for(RevolutCounterpartyAccountDTO revolutCounterpartyAccountDTO : revolutCounterpartyAccountDTOS) {
            revolutCounterpartyAccounts.add(mapToEntity(revolutCounterpartyAccountDTO));
        }

        return revolutCounterpartyAccounts;
    }
}
