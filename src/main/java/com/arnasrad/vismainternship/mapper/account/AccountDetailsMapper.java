package com.arnasrad.vismainternship.mapper.account;

import com.arnasrad.vismainternship.model.dto.account.AccountDetailsDTO;
import com.arnasrad.vismainternship.model.entity.account.AccountDetails;
import org.springframework.stereotype.Component;

@Component
public class AccountDetailsMapper {

    public AccountDetailsDTO mapToDTO(AccountDetails entity) {
        return new AccountDetailsDTO(entity.getIban(), entity.getSchemas(), entity.getAccountNo(),
                entity.getBankCountry());
    }

    public AccountDetails mapToEntity(AccountDetailsDTO dto) {
        return new AccountDetails(dto.getAccountNo(), dto.getIban(), dto.getSchemas(), dto.getBankCountry(), null,
                null, null, null, null, null, null, null);
    }
}
