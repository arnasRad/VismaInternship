package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.counterparty.CounterpartyAccountDTO;
import com.arnasrad.vismainternship.model.dto.counterparty.CounterpartyDTO;
import com.arnasrad.vismainternship.model.dto.revolut.counterparty.RevolutCounterpartyDTO;
import com.arnasrad.vismainternship.model.entity.counterparty.Counterparty;
import com.arnasrad.vismainternship.model.entity.counterparty.CounterpartyAccount;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CounterpartyMapper {

    public CounterpartyDTO mapToCounterpartyDTO(Counterparty entity) {
        CounterpartyDTO counterpartyDTO = new CounterpartyDTO();
        List<CounterpartyAccountDTO> counterpartyAccountDTOS = mapToCounterpartyAccountDTOArray(entity.getAccounts());

        counterpartyDTO.setCountry(entity.getCountry());
        counterpartyDTO.setId(entity.getCounterpartyId());
        counterpartyDTO.setName(entity.getName());
        counterpartyDTO.setPhone(entity.getPhone());
        counterpartyDTO.setAccounts(counterpartyAccountDTOS);

        return counterpartyDTO;
    }

    public RevolutCounterpartyDTO mapToRevolutCounterpartyDTO(Counterparty entity) {
        RevolutCounterpartyDTO revolutCounterpartyDTO = (RevolutCounterpartyDTO) mapToCounterpartyDTO(entity);

        revolutCounterpartyDTO.setProfileType(entity.getProfileType());
        revolutCounterpartyDTO.setState(entity.getState());
        revolutCounterpartyDTO.setCreatedAt(entity.getCreatedAt());
        revolutCounterpartyDTO.setUpdatedAt(entity.getUpdatedAt());

        return revolutCounterpartyDTO;
    }

    public CounterpartyAccountDTO mapToCounterpartyAccountDTO(CounterpartyAccount entity) {
        CounterpartyAccountDTO counterpartyAccountDTO = new CounterpartyAccountDTO();

        counterpartyAccountDTO.setId(entity.getCounterpartyAccountId());
        counterpartyAccountDTO.setCurrency(entity.getCurrency());
        counterpartyAccountDTO.setType(entity.getType());
        counterpartyAccountDTO.setAccountNo(entity.getAccountNo());
        counterpartyAccountDTO.setIban(entity.getIban());
        counterpartyAccountDTO.setSortCode(entity.getSortCode());
        counterpartyAccountDTO.setRoutingNumber(entity.getRoutingNumber());
        counterpartyAccountDTO.setBic(entity.getBic());
        counterpartyAccountDTO.setRecipientCharges(entity.getRecipientCharges());

        return counterpartyAccountDTO;
    }

    public Counterparty mapToCounterpartyEntity(CounterpartyDTO dto) {
        Counterparty counterparty = new Counterparty();
        List<CounterpartyAccount> counterpartyAccounts = mapToCounterpartyAccountEntityList(dto.getAccounts());

        counterparty.setCounterpartyId(dto.getId());
        counterparty.setCountry(dto.getCountry());
        counterparty.setName(dto.getName());
        counterparty.setPhone(dto.getPhone());
        counterparty.setAccounts(counterpartyAccounts);

        return counterparty;
    }

    public Counterparty mapToCounterpartyEntity(RevolutCounterpartyDTO dto) {
        Counterparty counterparty = new Counterparty();
        List<CounterpartyAccount> counterpartyAccounts = mapToCounterpartyAccountEntityList(dto.getAccounts());

        counterparty.setCounterpartyId(dto.getId());
        counterparty.setCountry(dto.getCountry());
        counterparty.setName(dto.getName());
        counterparty.setPhone(dto.getPhone());
        counterparty.setAccounts(counterpartyAccounts);
        counterparty.setProfileType(dto.getProfileType());
        counterparty.setState(dto.getState());
        counterparty.setCreatedAt(dto.getCreatedAt());
        counterparty.setUpdatedAt(dto.getUpdatedAt());

        return counterparty;
    }

    public CounterpartyAccount mapToCounterpartyAccountEntity(CounterpartyAccountDTO dto) {
        CounterpartyAccount counterpartyAccount = new CounterpartyAccount();

        counterpartyAccount.setCounterpartyAccountId(dto.getId());
        counterpartyAccount.setCurrency(dto.getCurrency());
        counterpartyAccount.setType(dto.getType());
        counterpartyAccount.setAccountNo(dto.getAccountNo());
        counterpartyAccount.setIban(dto.getIban());
        counterpartyAccount.setSortCode(dto.getSortCode());
        counterpartyAccount.setRoutingNumber(dto.getRoutingNumber());
        counterpartyAccount.setBic(dto.getBic());
        counterpartyAccount.setRecipientCharges(dto.getRecipientCharges());

        return counterpartyAccount;
    }

    public List<CounterpartyAccountDTO> mapToCounterpartyAccountDTOArray(List<CounterpartyAccount> counterpartyAccounts) {
        List<CounterpartyAccountDTO> counterpartyAccountDTOS = new ArrayList<>();

        for (CounterpartyAccount counterpartyAccount : counterpartyAccounts) {
            counterpartyAccountDTOS.add(mapToCounterpartyAccountDTO(counterpartyAccount));
        }

        return counterpartyAccountDTOS;
    }

    public List<CounterpartyAccount> mapToCounterpartyAccountEntityList(List<CounterpartyAccountDTO> counterpartyAccountDTOS) {
        List<CounterpartyAccount> counterpartyAccounts = new ArrayList<>();

        for (CounterpartyAccountDTO counterpartyAccountDTO : counterpartyAccountDTOS) {
            counterpartyAccounts.add(mapToCounterpartyAccountEntity(counterpartyAccountDTO));
        }

        return counterpartyAccounts;
    }
}
