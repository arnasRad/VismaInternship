package com.arnasrad.vismainternship.mapper.dnb.psd2api;

import com.arnasrad.vismainternship.model.dto.dnb.psd2api.DNBAccountDTO;
import com.arnasrad.vismainternship.model.entity.account.Account;
import org.springframework.stereotype.Component;

@Component
public class DNBAccountMapper {

    public DNBAccountDTO mapToDTO(Account entity) {
        return new DNBAccountDTO(entity.getAccountId(), entity.getName(), entity.getBalance());
    }

    public Account mapToEntity(DNBAccountDTO dto) {
        return new Account(dto.getId(), dto.getName(), dto.getBalance(), null, null, null, null, null);
    }
}
