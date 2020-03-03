package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.account.AccountDto;
import com.arnasrad.vismainternship.model.dto.dnb.account.DnbAccountDto;
import com.arnasrad.vismainternship.model.dto.revolut.account.RevolutAccountDto;
import com.arnasrad.vismainternship.model.entity.account.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public AccountDto mapToAccountDto(Account entity) {
        AccountDto accountDto = new AccountDto();

        accountDto.setId(entity.getAccountId());
        accountDto.setName(entity.getName());
        accountDto.setBalance(entity.getBalance());

        return accountDto;
    }

    public DnbAccountDto mapToDnbAccountDto(Account entity) {
        DnbAccountDto accountDto = new DnbAccountDto();

        accountDto.setId(entity.getAccountId());
        accountDto.setName(entity.getName());
        accountDto.setBalance(entity.getBalance());

        return accountDto;
    }

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

    public Account mapToAccountEntity(AccountDto dto) {
        Account account = new Account();

        account.setAccountId(dto.getId());
        account.setName(dto.getName());
        account.setBalance(dto.getBalance());

        return account;
    }

    public Account mapToAccountEntity(DnbAccountDto dto) {
        Account account = new Account();

        account.setAccountId(dto.getId());
        account.setName(dto.getName());
        account.setBalance(dto.getBalance());

        return account;
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
