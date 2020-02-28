package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.token.DNBTokenDTO;
import com.arnasrad.vismainternship.model.dto.token.RevolutTokenDTO;
import com.arnasrad.vismainternship.model.entity.token.Token;
import org.springframework.stereotype.Component;

@Component
public class TokenMapper {

    public DNBTokenDTO mapToDNBTokenDTO(Token entity) {
        DNBTokenDTO dnbTokenDTO = new DNBTokenDTO();

        dnbTokenDTO.setCustomerPublicId(entity.getCustomerPublicId());
        dnbTokenDTO.setJwtToken(entity.getToken());

        return dnbTokenDTO;
    }

    public RevolutTokenDTO mapToRevolutTokenDTO(Token entity) {
        RevolutTokenDTO revolutTokenDTO = new RevolutTokenDTO();

        revolutTokenDTO.setAccessToken(entity.getToken());
        revolutTokenDTO.setTokenType(entity.getTokenType());
        revolutTokenDTO.setExpiresId(entity.getExpiresId());

        return revolutTokenDTO;
    }

    public Token mapToTokenEntity(DNBTokenDTO dto) {
        Token token = new Token();

        token.setClientId(dto.getClientId());
        token.setToken(dto.getJwtToken());
        token.setCustomerPublicId(dto.getCustomerPublicId());

        return token;
    }

    public Token mapToTokenEntity(RevolutTokenDTO dto) {
        Token token = new Token();

        token.setClientId(dto.getClientId());
        token.setToken(dto.getAccessToken());
        token.setTokenType(dto.getTokenType());
        token.setExpiresId(dto.getExpiresId());

        return token;
    }
}
