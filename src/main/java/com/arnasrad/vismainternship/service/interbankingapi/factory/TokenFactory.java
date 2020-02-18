package com.arnasrad.vismainternship.service.interbankingapi.factory;

import com.arnasrad.vismainternship.service.dnb.openbankingapi.RefreshJwtTokenService;
import com.arnasrad.vismainternship.service.interbankingapi.ResponseStatusExceptionBuilderService;
import com.arnasrad.vismainternship.service.interbankingapi.request.TokenService;
import com.arnasrad.vismainternship.service.revolut.RefreshAccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.arnasrad.vismainternship.model.enums.BankId.DNB_ID;
import static com.arnasrad.vismainternship.model.enums.BankId.REVOLUT_ID;

@Component
public class TokenFactory {

    private final RefreshAccessTokenService refreshAccessTokenService;
    private final RefreshJwtTokenService refreshJwtTokenService;
    private final ResponseStatusExceptionBuilderService exceptionBuilder;

    @Autowired
    public TokenFactory(RefreshAccessTokenService refreshAccessTokenService, RefreshJwtTokenService refreshJwtTokenService, ResponseStatusExceptionBuilderService exceptionBuilder) {
        this.refreshAccessTokenService = refreshAccessTokenService;
        this.refreshJwtTokenService = refreshJwtTokenService;
        this.exceptionBuilder = exceptionBuilder;
    }

    public TokenService getService(String bank) {

        switch (bank) {
            case REVOLUT_ID:
                return refreshAccessTokenService;
            case DNB_ID:
                return refreshJwtTokenService;
            default:
                throw exceptionBuilder.getWrongBankException400();
        }
    }
}
