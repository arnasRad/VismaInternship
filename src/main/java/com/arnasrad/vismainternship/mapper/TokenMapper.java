package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.token.DNBTokenDto;
import com.arnasrad.vismainternship.model.dto.token.RevolutTokenDto;
import com.arnasrad.vismainternship.model.entity.token.Token;
import org.springframework.stereotype.Component;

@Component
public class TokenMapper {

    public DNBTokenDto mapToDNBTokenDTO(Token entity) {
        DNBTokenDto dnbTokenDTO = new DNBTokenDto();

        dnbTokenDTO.setCustomerPublicId(entity.getCustomerPublicId());
        dnbTokenDTO.setJwtToken(entity.getToken());

        return dnbTokenDTO;
    }

    public RevolutTokenDto mapToRevolutTokenDTO(Token entity) {
        RevolutTokenDto revolutTokenDTO = new RevolutTokenDto();

        revolutTokenDTO.setAccessToken(entity.getToken());
        revolutTokenDTO.setTokenType(entity.getTokenType());
        revolutTokenDTO.setExpiresId(entity.getExpiresId());

        return revolutTokenDTO;
    }

    public Token mapToTokenEntity(Token token, DNBTokenDto dto) {
        token.setClientId(dto.getClientId());
        token.setToken(dto.getJwtToken());
        token.setCustomerPublicId(dto.getCustomerPublicId());

        return token;
    }

    public Token mapToTokenEntity(Token token, RevolutTokenDto dto) {
        token.setClientId(dto.getClientId());
        token.setToken(dto.getAccessToken());
        token.setTokenType(dto.getTokenType());
        token.setExpiresId(dto.getExpiresId());

        return token;
    }
}
