package com.arnasrad.vismainternship.mapper.token;

import com.arnasrad.vismainternship.model.dto.token.DNBTokenDTO;
import com.arnasrad.vismainternship.model.entity.token.Token;
import org.springframework.stereotype.Component;

@Component
public class DNBTokenMapper {

    public DNBTokenDTO mapToDTO(Token entity) {
        return new DNBTokenDTO(entity.getCustomerPublicId(), entity.getToken());
    }

    public Token mapToEntity(DNBTokenDTO dto) {
        return new Token(dto.getJwtToken(), null, null, dto.getCustomerPublicId());
    }
}
