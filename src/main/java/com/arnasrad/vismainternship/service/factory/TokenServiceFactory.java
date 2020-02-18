package com.arnasrad.vismainternship.service.factory;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.service.request.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TokenServiceFactory {

    private List<TokenService> tokenServiceList;

    @Autowired
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
