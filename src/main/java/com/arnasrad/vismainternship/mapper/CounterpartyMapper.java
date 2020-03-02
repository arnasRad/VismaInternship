package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.counterparty.CounterpartyAccountDto;
import com.arnasrad.vismainternship.model.dto.counterparty.CounterpartyDto;
import com.arnasrad.vismainternship.model.dto.revolut.counterparty.RevolutCounterpartyDto;
import com.arnasrad.vismainternship.model.entity.counterparty.Counterparty;
import com.arnasrad.vismainternship.model.entity.counterparty.CounterpartyAccount;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CounterpartyMapper {

    public CounterpartyDto mapToCounterpartyDTO(Counterparty entity) {
        CounterpartyDto counterpartyDTO = new CounterpartyDto();
        List<CounterpartyAccountDto> counterpartyAccountDtos = mapToCounterpartyAccountDTOArray(entity.getAccounts());

        counterpartyDTO.setCountry(entity.getCountry());
        counterpartyDTO.setId(entity.getCounterpartyId());
        counterpartyDTO.setName(entity.getName());
        counterpartyDTO.setPhone(entity.getPhone());
        counterpartyDTO.setAccounts(counterpartyAccountDtos);

        return counterpartyDTO;
    }

    public RevolutCounterpartyDto mapToRevolutCounterpartyDTO(Counterparty entity) {
        RevolutCounterpartyDto revolutCounterpartyDTO = (RevolutCounterpartyDto) mapToCounterpartyDTO(entity);

        revolutCounterpartyDTO.setProfileType(entity.getProfileType());
        revolutCounterpartyDTO.setState(entity.getState());
        revolutCounterpartyDTO.setCreatedAt(entity.getCreatedAt());
        revolutCounterpartyDTO.setUpdatedAt(entity.getUpdatedAt());

        return revolutCounterpartyDTO;
    }

    public CounterpartyAccountDto mapToCounterpartyAccountDTO(CounterpartyAccount entity) {
        CounterpartyAccountDto counterpartyAccountDTO = new CounterpartyAccountDto();

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

    public Counterparty mapToCounterpartyEntity(CounterpartyDto dto) {
        Counterparty counterparty = new Counterparty();
        List<CounterpartyAccount> counterpartyAccounts = mapToCounterpartyAccountEntityList(dto.getAccounts());

        counterparty.setCounterpartyId(dto.getId());
        counterparty.setCountry(dto.getCountry());
        counterparty.setName(dto.getName());
        counterparty.setPhone(dto.getPhone());
        counterparty.setAccounts(counterpartyAccounts);

        return counterparty;
    }

    public Counterparty mapToCounterpartyEntity(RevolutCounterpartyDto dto) {
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

    public CounterpartyAccount mapToCounterpartyAccountEntity(CounterpartyAccountDto dto) {
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

    public List<CounterpartyAccountDto> mapToCounterpartyAccountDTOArray(List<CounterpartyAccount> counterpartyAccounts) {
        List<CounterpartyAccountDto> counterpartyAccountDtos = new ArrayList<>();

        for (CounterpartyAccount counterpartyAccount : counterpartyAccounts) {
            counterpartyAccountDtos.add(mapToCounterpartyAccountDTO(counterpartyAccount));
        }

        return counterpartyAccountDtos;
    }

    public List<CounterpartyAccount> mapToCounterpartyAccountEntityList(List<CounterpartyAccountDto> counterpartyAccountDtos) {
        List<CounterpartyAccount> counterpartyAccounts = new ArrayList<>();

        for (CounterpartyAccountDto counterpartyAccountDTO : counterpartyAccountDtos) {
            counterpartyAccounts.add(mapToCounterpartyAccountEntity(counterpartyAccountDTO));
        }

        return counterpartyAccounts;
    }
}
