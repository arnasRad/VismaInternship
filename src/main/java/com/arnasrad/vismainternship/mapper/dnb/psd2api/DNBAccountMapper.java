package com.arnasrad.vismainternship.mapper.dnb.psd2api;

import com.arnasrad.vismainternship.model.dto.dnb.psd2api.DNBAccountDTO;
import com.arnasrad.vismainternship.model.entity.dnb.psd2api.DNBAccount;

public class DNBAccountMapper {

    public DNBAccountDTO mapToDTO(DNBAccount entity) {
        return new DNBAccountDTO(entity.getAccountId(), entity.getName(), entity.getBalance());
    }

    public DNBAccount mapToEntity(DNBAccountDTO dto) {
        return new DNBAccount(dto.getId(), dto.getName(), dto.getBalance());
    }
}
