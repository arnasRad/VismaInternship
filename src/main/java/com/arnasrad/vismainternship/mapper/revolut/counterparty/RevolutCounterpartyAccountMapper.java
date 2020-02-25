package com.arnasrad.vismainternship.mapper.revolut.counterparty;

import com.arnasrad.vismainternship.model.dto.revolut.counterparty.RevolutCounterpartyAccountDTO;
import com.arnasrad.vismainternship.model.entity.revolut.counterparty.RevolutCounterpartyAccount;

import java.util.ArrayList;
import java.util.List;


public class RevolutCounterpartyAccountMapper {

    public RevolutCounterpartyAccountDTO mapToDTO(RevolutCounterpartyAccount entity) {
        return new RevolutCounterpartyAccountDTO(entity.getCounterpartyAccountId(), entity.getCurrency(),
                entity.getType(), entity.getAccountNo(), entity.getIban(), entity.getSortCode(),
                entity.getRoutingNumber(), entity.getBic(), entity.getRecipientCharges());
    }

    public RevolutCounterpartyAccount mapToEntity(RevolutCounterpartyAccountDTO dto) {
        return new RevolutCounterpartyAccount(dto.getId(), dto.getCurrency(), dto.getType(), dto.getAccountNo(),
                dto.getIban(), dto.getSortCode(), dto.getRoutingNumber(), dto.getBic(), dto.getRecipientCharges());
    }

    public List<RevolutCounterpartyAccountDTO> mapToDTOArray(List<RevolutCounterpartyAccount> revolutCounterpartyAccounts) {
        List<RevolutCounterpartyAccountDTO> revolutCounterpartyAccountDTOS = new ArrayList<>();

        for (RevolutCounterpartyAccount revolutCounterpartyAccount : revolutCounterpartyAccounts) {
            revolutCounterpartyAccountDTOS.add(mapToDTO(revolutCounterpartyAccount));
        }

        return revolutCounterpartyAccountDTOS;
    }

    public List<RevolutCounterpartyAccount> mapToEntityList(List<RevolutCounterpartyAccountDTO> revolutCounterpartyAccountDTOS) {
        List<RevolutCounterpartyAccount> revolutCounterpartyAccounts = new ArrayList<>();

        for(RevolutCounterpartyAccountDTO revolutCounterpartyAccountDTO : revolutCounterpartyAccountDTOS) {
            revolutCounterpartyAccounts.add(mapToEntity(revolutCounterpartyAccountDTO));
        }

        return revolutCounterpartyAccounts;
    }
}
