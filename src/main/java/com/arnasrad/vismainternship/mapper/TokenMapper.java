package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.token.DnbConsentDto;
import com.arnasrad.vismainternship.model.dto.token.DnbTokenDto;
import com.arnasrad.vismainternship.model.dto.token.RevolutTokenDto;
import com.arnasrad.vismainternship.model.entity.token.Token;
import org.springframework.stereotype.Component;

@Component
public class TokenMapper {

    public DnbTokenDto mapToDNBTokenDto(Token entity) {
        DnbTokenDto dnbTokenDto = new DnbTokenDto();

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

    public Token mapToTokenEntity(Token token, DnbTokenDto dto) {
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

    public Token mapToTokenEntity(Token token, DnbConsentDto dto) {
        token.setClientId(dto.getClientId());
        token.setToken(dto.getConsentId());

        return token;
    }
}
