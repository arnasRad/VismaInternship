package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.account.AccountDTO;
import com.arnasrad.vismainternship.model.dto.dnb.psd2api.DNBAccountDTO;
import com.arnasrad.vismainternship.model.dto.revolut.account.RevolutAccountDTO;
import com.arnasrad.vismainternship.model.entity.account.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public AccountDTO mapToAccountDTO(Account entity) {
        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setId(entity.getAccountId());
        accountDTO.setName(entity.getName());
        accountDTO.setBalance(entity.getBalance());

        return accountDTO;
    }

    public DNBAccountDTO mapToDnbAccountDTO(Account entity) {
        DNBAccountDTO accountDTO = new DNBAccountDTO();

        accountDTO.setId(entity.getAccountId());
        accountDTO.setName(entity.getName());
        accountDTO.setBalance(entity.getBalance());

        return accountDTO;
    }

    public RevolutAccountDTO mapToRevolutAccountDTO(Account entity) {
        RevolutAccountDTO revolutAccountDTO = new RevolutAccountDTO();

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

    public Account mapToAccountEntity(AccountDTO dto) {
        Account account = new Account();

        account.setAccountId(dto.getId());
        account.setName(dto.getName());
        account.setBalance(dto.getBalance());

        return account;
    }

    public Account mapToAccountEntity(DNBAccountDTO dto) {
        Account account = new Account();

        account.setAccountId(dto.getId());
        account.setName(dto.getName());
        account.setBalance(dto.getBalance());

        return account;
    }

    public Account mapToAccountEntity(RevolutAccountDTO dto) {
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
