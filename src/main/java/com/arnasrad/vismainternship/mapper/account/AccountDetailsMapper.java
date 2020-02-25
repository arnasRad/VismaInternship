package com.arnasrad.vismainternship.mapper.account;

import com.arnasrad.vismainternship.model.dto.account.AccountDetailsDTO;
import com.arnasrad.vismainternship.model.entity.account.AccountDetails;

public class AccountDetailsMapper {

    public AccountDetailsDTO mapToDTO(AccountDetails entity) {
        return new AccountDetailsDTO(entity.getIban(), entity.getSchemas(),
                entity.getAccountNo(),
                entity.getBankCountry());
    }

    public AccountDetails mapToEntity(AccountDetailsDTO dto) {
        return new AccountDetails(dto.getIban(), dto.getSchemas(), dto.getAccountNo(),
                dto.getBankCountry());
    }
}
