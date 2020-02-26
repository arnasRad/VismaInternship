package com.arnasrad.vismainternship.mapper.token;

import com.arnasrad.vismainternship.model.dto.token.RevolutTokenDTO;
import com.arnasrad.vismainternship.model.entity.token.Token;
import org.springframework.stereotype.Component;

@Component
public class RevolutTokenMapper {

    public RevolutTokenDTO mapToDTO(Token entity) {
        return new RevolutTokenDTO(entity.getToken(), entity.getTokenType(), entity.getExpiresId());
    }

    public Token mapToEntity(RevolutTokenDTO dto) {
        return new Token(dto.getAccessToken(), dto.getTokenType(), dto.getExpiresId(), null);
    }
}
