package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.factory.TokenServiceFactory;
import com.arnasrad.vismainternship.service.request.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("interbanking-token-controller")
public class TokenController {

    private final TokenServiceFactory tokenServiceFactory;

    public TokenController(TokenServiceFactory tokenServiceFactory) {
        this.tokenServiceFactory = tokenServiceFactory;
    }

    @PostMapping("/interbanking/refresh-token")
    public String refreshToken(@RequestParam String bank, @RequestParam(defaultValue = "") String ssn)
            throws NoSuchFunctionalityException {
        TokenService service = tokenServiceFactory.getService(bank);
        return service.refreshAndGetToken(ssn);
    }
}
