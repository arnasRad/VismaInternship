package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.token.DNBTokenDto;
import com.arnasrad.vismainternship.model.dto.token.RevolutTokenDto;
import com.arnasrad.vismainternship.model.entity.token.Token;
import org.springframework.stereotype.Component;

@Component
public class TokenMapper {

    public DNBTokenDto mapToDNBTokenDto(Token entity) {
        DNBTokenDto dnbTokenDto = new DNBTokenDto();

        dnbTokenDto.setCustomerPublicId(entity.getCustomerPublicId());
        dnbTokenDto.setJwtToken(entity.getToken());

        return dnbTokenDto;
    }

    public RevolutTokenDto mapToRevolutTokenDto(Token entity) {
        RevolutTokenDto revolutTokenDto = new RevolutTokenDto();

        revolutTokenDto.setAccessToken(entity.getToken());
        revolutTokenDto.setTokenType(entity.getTokenType());
        revolutTokenDto.setExpiresId(entity.getExpiresId());

        return revolutTokenDto;
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
