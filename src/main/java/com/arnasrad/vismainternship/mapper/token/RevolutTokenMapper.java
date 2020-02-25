package com.arnasrad.vismainternship.mapper.token;

import com.arnasrad.vismainternship.model.dto.token.RevolutTokenDTO;
import com.arnasrad.vismainternship.model.entity.token.RevolutToken;

public class RevolutTokenMapper {

    public RevolutTokenDTO mapToDTO(RevolutToken entity) {
        return new RevolutTokenDTO(entity.getAccessToken(), entity.getTokenType(), entity.getExpiresId());
    }

    public RevolutToken mapToEntity(RevolutTokenDTO dto) {
        return new RevolutToken(dto.getAccessToken(), dto.getTokenType(), dto.getExpiresId());
    }
}
