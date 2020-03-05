package com.arnasrad.vismainternship.mapper.revolut;

import com.arnasrad.vismainternship.model.dto.AccountDto;
import com.arnasrad.vismainternship.model.dto.revolut.account.RevolutAccountDto;
import com.arnasrad.vismainternship.model.dto.revolut.counterparty.RevolutCounterpartyAccountDto;
import com.arnasrad.vismainternship.model.entity.account.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RevolutAccountMapper {

    public RevolutAccountDto mapToRevolutAccountDto(Account entity) {
        RevolutAccountDto revolutAccountDto = new RevolutAccountDto();

        revolutAccountDto.setId(entity.getAccountId());
        revolutAccountDto.setName(entity.getName());
        revolutAccountDto.setBalance(entity.getBalance());
        revolutAccountDto.setCurrency(entity.getCurrency());
        revolutAccountDto.setState(entity.getState());
        revolutAccountDto.setPublic(entity.getPublic());
        revolutAccountDto.setCreatedAt(entity.getCreatedAt());
        revolutAccountDto.setUpdatedAt(entity.getUpdatedAt());

        return revolutAccountDto;
    }

    public AccountDto mapToAccountDto(RevolutAccountDto revolutAccountDto) {
        AccountDto accountDto = new AccountDto();

        accountDto.setIban(revolutAccountDto.getId());
        String balance = String.valueOf(revolutAccountDto.getBalance());
        accountDto.setBalance(balance);
        accountDto.setCurrency(revolutAccountDto.getCurrency());

        return accountDto;
    }

    public AccountDto mapToAccountDto(RevolutCounterpartyAccountDto revolutCounterpartyAccountDto) {
        AccountDto accountDto = new AccountDto();

        accountDto.setIban(revolutCounterpartyAccountDto.getIban());
        accountDto.setCurrency(revolutCounterpartyAccountDto.getCurrency());

        return accountDto;
    }

    public List<AccountDto> mapToAccountDtoList(ResponseEntity<List<RevolutAccountDto>> responseEntity) {
        List<RevolutAccountDto> revolutAccountDtoList = responseEntity.getBody();
        return mapToAccountDtoList(revolutAccountDtoList);
    }

    public List<AccountDto> mapToAccountDtoList(List<RevolutAccountDto> revolutAccountDtoList) {
        List<AccountDto> accountDtoList = new ArrayList<>();

        for(RevolutAccountDto revolutAccountDto : revolutAccountDtoList) {
            AccountDto accountDto = mapToAccountDto(revolutAccountDto);
            accountDtoList.add(accountDto);
        }

        return accountDtoList;
    }

    public List<AccountDto> mapCounterpartyAccountDtoListToAccountDtoList(List<RevolutCounterpartyAccountDto> revolutCounterpartyAccountDtoList) {
        List<AccountDto> accountDtoList = new ArrayList<>();

        for(RevolutCounterpartyAccountDto revolutCounterpartyAccountDto : revolutCounterpartyAccountDtoList) {
            AccountDto accountDto = mapToAccountDto(revolutCounterpartyAccountDto);
            accountDtoList.add(accountDto);
        }

        return accountDtoList;
    }

    public Account mapToAccountEntity(RevolutAccountDto dto) {
        Account account = new Account();

        account.setAccountId(dto.getId());
        account.setName(dto.getName());
        account.setBalance(dto.getBalance());
        account.setCurrency(dto.getCurrency());
        account.setState(dto.getState());
        account.setPublic(dto.getPublic());
        account.setCreatedAt(dto.getCreatedAt());
        account.setUpdatedAt(dto.getUpdatedAt());

        return account;
    }
}
