package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.account.AccountDto;
import com.arnasrad.vismainternship.model.dto.dnb.psd2api.DNBAccountDto;
import com.arnasrad.vismainternship.model.dto.revolut.account.RevolutAccountDto;
import com.arnasrad.vismainternship.model.entity.account.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public AccountDto mapToAccountDTO(Account entity) {
        AccountDto accountDTO = new AccountDto();

        accountDTO.setId(entity.getAccountId());
        accountDTO.setName(entity.getName());
        accountDTO.setBalance(entity.getBalance());

        return accountDTO;
    }

    public DNBAccountDto mapToDnbAccountDTO(Account entity) {
        DNBAccountDto accountDTO = new DNBAccountDto();

        accountDTO.setId(entity.getAccountId());
        accountDTO.setName(entity.getName());
        accountDTO.setBalance(entity.getBalance());

        return accountDTO;
    }

    public RevolutAccountDto mapToRevolutAccountDTO(Account entity) {
        RevolutAccountDto revolutAccountDTO = new RevolutAccountDto();

        revolutAccountDTO.setId(entity.getAccountId());
        revolutAccountDTO.setName(entity.getName());
        revolutAccountDTO.setBalance(entity.getBalance());
        revolutAccountDTO.setCurrency(entity.getCurrency());
        revolutAccountDTO.setState(entity.getState());
        revolutAccountDTO.setPublic(entity.getPublic());
        revolutAccountDTO.setCreatedAt(entity.getCreatedAt());
        revolutAccountDTO.setUpdatedAt(entity.getUpdatedAt());

        return revolutAccountDTO;
    }

    public Account mapToAccountEntity(AccountDto dto) {
        Account account = new Account();

        account.setAccountId(dto.getId());
        account.setName(dto.getName());
        account.setBalance(dto.getBalance());

        return account;
    }

    public Account mapToAccountEntity(DNBAccountDto dto) {
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
