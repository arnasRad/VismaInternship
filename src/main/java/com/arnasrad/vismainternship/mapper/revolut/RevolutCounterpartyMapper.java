package com.arnasrad.vismainternship.mapper.revolut;

import com.arnasrad.vismainternship.model.dto.AccountDto;
import com.arnasrad.vismainternship.model.dto.CounterpartyDto;
import com.arnasrad.vismainternship.model.dto.revolut.counterparty.RevolutCounterpartyAccountDto;
import com.arnasrad.vismainternship.model.dto.revolut.counterparty.RevolutCounterpartyDto;
import com.arnasrad.vismainternship.model.entity.counterparty.Counterparty;
import com.arnasrad.vismainternship.model.entity.counterparty.CounterpartyAccount;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RevolutCounterpartyMapper {

    private final RevolutAccountMapper revolutAccountMapper;

    public RevolutCounterpartyMapper(RevolutAccountMapper revolutAccountMapper) {
        this.revolutAccountMapper = revolutAccountMapper;
    }

    public RevolutCounterpartyDto mapToRevolutCounterpartyDto(Counterparty entity) {
        RevolutCounterpartyDto revolutCounterpartyDto = new RevolutCounterpartyDto();
        List<RevolutCounterpartyAccountDto> revolutCounterpartyAccountDtos = mapToCounterpartyAccountDtoArray(entity.getAccounts());

        revolutCounterpartyDto.setCountry(entity.getCountry());
        revolutCounterpartyDto.setId(entity.getCounterpartyId());
        revolutCounterpartyDto.setName(entity.getName());
        revolutCounterpartyDto.setPhone(entity.getPhone());
        revolutCounterpartyDto.setAccounts(revolutCounterpartyAccountDtos);
        revolutCounterpartyDto.setProfileType(entity.getProfileType());
        revolutCounterpartyDto.setState(entity.getState());
        revolutCounterpartyDto.setCreatedAt(entity.getCreatedAt());
        revolutCounterpartyDto.setUpdatedAt(entity.getUpdatedAt());

        return revolutCounterpartyDto;
    }

    public RevolutCounterpartyAccountDto mapToCounterpartyAccountDto(CounterpartyAccount entity) {
        RevolutCounterpartyAccountDto revolutCounterpartyAccountDto = new RevolutCounterpartyAccountDto();

        revolutCounterpartyAccountDto.setId(entity.getCounterpartyAccountId());
        revolutCounterpartyAccountDto.setCurrency(entity.getCurrency());
        revolutCounterpartyAccountDto.setType(entity.getType());
        revolutCounterpartyAccountDto.setAccountNo(entity.getAccountNo());
        revolutCounterpartyAccountDto.setIban(entity.getIban());
        revolutCounterpartyAccountDto.setSortCode(entity.getSortCode());
        revolutCounterpartyAccountDto.setRoutingNumber(entity.getRoutingNumber());
        revolutCounterpartyAccountDto.setBic(entity.getBic());
        revolutCounterpartyAccountDto.setRecipientCharges(entity.getRecipientCharges());

        return revolutCounterpartyAccountDto;
    }

    public CounterpartyDto mapToCounterpartyDto(RevolutCounterpartyDto revolutCounterpartyDto) {
        CounterpartyDto counterpartyDto = new CounterpartyDto();

        List<RevolutCounterpartyAccountDto> counterpartyAccountDtoList = revolutCounterpartyDto.getAccounts();
        List<AccountDto> accountDtoList =
                revolutAccountMapper.mapCounterpartyAccountDtoListToAccountDtoList(counterpartyAccountDtoList);
        counterpartyDto.setAccounts(accountDtoList);
        counterpartyDto.setName(revolutCounterpartyDto.getName());

        return counterpartyDto;
    }

    public List<CounterpartyDto> mapToCounterpartyDtoList(List<RevolutCounterpartyDto> revolutCounterpartyDtoList) {
        List<CounterpartyDto> counterpartyDtoList = new ArrayList<>();

        for(RevolutCounterpartyDto revolutCounterpartyDto : revolutCounterpartyDtoList) {
            CounterpartyDto counterpartyDto = mapToCounterpartyDto(revolutCounterpartyDto);
            counterpartyDtoList.add(counterpartyDto);
        }

        return counterpartyDtoList;
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

    public CounterpartyAccount mapToCounterpartyAccountEntity(RevolutCounterpartyAccountDto dto) {
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

    public List<RevolutCounterpartyAccountDto> mapToCounterpartyAccountDtoArray(List<CounterpartyAccount> counterpartyAccounts) {
        List<RevolutCounterpartyAccountDto> revolutCounterpartyAccountDtos = new ArrayList<>();

        for (CounterpartyAccount counterpartyAccount : counterpartyAccounts) {
            revolutCounterpartyAccountDtos.add(mapToCounterpartyAccountDto(counterpartyAccount));
        }

        return revolutCounterpartyAccountDtos;
    }

    public List<CounterpartyAccount> mapToCounterpartyAccountEntityList(List<RevolutCounterpartyAccountDto> revolutCounterpartyAccountDtos) {
        List<CounterpartyAccount> counterpartyAccounts = new ArrayList<>();

        for (RevolutCounterpartyAccountDto revolutCounterpartyAccountDto : revolutCounterpartyAccountDtos) {
            counterpartyAccounts.add(mapToCounterpartyAccountEntity(revolutCounterpartyAccountDto));
        }

        return counterpartyAccounts;
    }
}
