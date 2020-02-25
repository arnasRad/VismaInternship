package com.arnasrad.vismainternship.mapper.token;

import com.arnasrad.vismainternship.model.dto.token.DNBTokenDTO;
import com.arnasrad.vismainternship.model.entity.token.DNBToken;

public class DNBTokenMapper {

    public DNBTokenDTO mapToDTO(DNBToken entity) {
        return new DNBTokenDTO(entity.getCustomerPublicId(), entity.getJwtToken());
    }

    public DNBToken mapToEntity(DNBTokenDTO dto) {
        return new DNBToken(dto.getCustomerPublicId(), dto.getJwtToken());
    }
}
