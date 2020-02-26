package com.arnasrad.vismainternship.mapper.revolut.account;

import com.arnasrad.vismainternship.model.dto.revolut.account.RevolutAccountDTO;
import com.arnasrad.vismainternship.model.entity.account.Account;
import org.springframework.stereotype.Component;

@Component
public class RevolutAccountMapper {

    public RevolutAccountDTO mapToDTO(Account entity) {
        return new RevolutAccountDTO(entity.getAccountId(), entity.getName(), entity.getBalance(),
                entity.getCurrency(), entity.getState(), entity.getPublic(), entity.getCreatedAt(),
                entity.getUpdatedAt());
    }

    public Account mapToEntity(RevolutAccountDTO dto) {
        return new Account(dto.getId(), dto.getName(), dto.getBalance(), dto.getCurrency(), dto.getState(),
                dto.getPublic(), dto.getCreatedAt(), dto.getUpdatedAt());
    }
}
