package com.arnasrad.vismainternship.mapper.revolut.account;

import com.arnasrad.vismainternship.model.dto.revolut.account.RevolutAccountDTO;
import com.arnasrad.vismainternship.model.entity.revolut.account.RevolutAccount;


public class RevolutAccountMapper {

    public RevolutAccountDTO mapToDTO(RevolutAccount entity) {
        return new RevolutAccountDTO(entity.getAccountId(), entity.getName(), entity.getBalance(),
                entity.getCurrency(), entity.getState(), entity.getPublic(), entity.getCreatedAt(),
                entity.getUpdatedAt());
    }

    public RevolutAccount mapToEntity(RevolutAccountDTO dto) {
        return new RevolutAccount(dto.getId(), dto.getName(), dto.getBalance(), dto.getCurrency(), dto.getState(),
                dto.getPublic(), dto.getCreatedAt(), dto.getUpdatedAt());
    }
}
