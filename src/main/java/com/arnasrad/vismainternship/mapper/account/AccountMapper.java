package com.arnasrad.vismainternship.mapper.account;

import com.arnasrad.vismainternship.model.dto.account.AccountDTO;
import com.arnasrad.vismainternship.model.entity.account.Account;

public class AccountMapper {

    public AccountDTO mapToDTO(Account entity) {
        return new AccountDTO(entity.getAccountId(), entity.getName(), entity.getBalance());
    }

    public Account mapToEntity(AccountDTO dto) {
        return new Account(dto.getId(), dto.getName(), dto.getBalance());
    }
}
