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

    public CounterpartyDto mapToCounterpartyDto(Counterparty entity) {
        CounterpartyDto counterpartyDto = new CounterpartyDto();
        List<CounterpartyAccountDto> counterpartyAccountDtos = mapToCounterpartyAccountDtoArray(entity.getAccounts());

        counterpartyDto.setCountry(entity.getCountry());
        counterpartyDto.setId(entity.getCounterpartyId());
        counterpartyDto.setName(entity.getName());
        counterpartyDto.setPhone(entity.getPhone());
        counterpartyDto.setAccounts(counterpartyAccountDtos);

        return counterpartyDto;
    }

    public RevolutCounterpartyDto mapToRevolutCounterpartyDto(Counterparty entity) {
        RevolutCounterpartyDto revolutCounterpartyDto = (RevolutCounterpartyDto) mapToCounterpartyDto(entity);

        revolutCounterpartyDto.setProfileType(entity.getProfileType());
        revolutCounterpartyDto.setState(entity.getState());
        revolutCounterpartyDto.setCreatedAt(entity.getCreatedAt());
        revolutCounterpartyDto.setUpdatedAt(entity.getUpdatedAt());

        return revolutCounterpartyDto;
    }

    public CounterpartyAccountDto mapToCounterpartyAccountDto(CounterpartyAccount entity) {
        CounterpartyAccountDto counterpartyAccountDto = new CounterpartyAccountDto();

        counterpartyAccountDto.setId(entity.getCounterpartyAccountId());
        counterpartyAccountDto.setCurrency(entity.getCurrency());
        counterpartyAccountDto.setType(entity.getType());
        counterpartyAccountDto.setAccountNo(entity.getAccountNo());
        counterpartyAccountDto.setIban(entity.getIban());
        counterpartyAccountDto.setSortCode(entity.getSortCode());
        counterpartyAccountDto.setRoutingNumber(entity.getRoutingNumber());
        counterpartyAccountDto.setBic(entity.getBic());
        counterpartyAccountDto.setRecipientCharges(entity.getRecipientCharges());

        return counterpartyAccountDto;
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

    public List<CounterpartyAccountDto> mapToCounterpartyAccountDtoArray(List<CounterpartyAccount> counterpartyAccounts) {
        List<CounterpartyAccountDto> counterpartyAccountDtos = new ArrayList<>();

        for (CounterpartyAccount counterpartyAccount : counterpartyAccounts) {
            counterpartyAccountDtos.add(mapToCounterpartyAccountDto(counterpartyAccount));
        }

        return counterpartyAccountDtos;
    }

    public List<CounterpartyAccount> mapToCounterpartyAccountEntityList(List<CounterpartyAccountDto> counterpartyAccountDtos) {
        List<CounterpartyAccount> counterpartyAccounts = new ArrayList<>();

        for (CounterpartyAccountDto counterpartyAccountDto : counterpartyAccountDtos) {
            counterpartyAccounts.add(mapToCounterpartyAccountEntity(counterpartyAccountDto));
        }

        return counterpartyAccounts;
    }
}
