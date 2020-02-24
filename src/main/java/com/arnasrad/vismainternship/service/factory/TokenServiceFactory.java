package com.arnasrad.vismainternship.service.factory;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.service.request.TokenService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenServiceFactory {

    private List<TokenService> tokenServiceList;

    public TokenServiceFactory(List<TokenService> tokenServiceList) {
        this.tokenServiceList = tokenServiceList;
    }

    public TokenService getService(String bank) {
        return tokenServiceList.stream()
                .filter(tokenService -> tokenService.getBankId().equals(bank))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(ErrorMessages.WRONG_BANK));
    }
}
