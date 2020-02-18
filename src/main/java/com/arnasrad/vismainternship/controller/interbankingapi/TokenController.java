package com.arnasrad.vismainternship.controller.interbankingapi;

import com.arnasrad.vismainternship.component.OptionalValueProcessor;
import com.arnasrad.vismainternship.service.interbankingapi.factory.TokenFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("interbanking-token-controller")
public class TokenController {

    private final OptionalValueProcessor optionalValueProcessor;
    private final TokenFactory tokenFactory;

    @Autowired
    public TokenController(OptionalValueProcessor optionalValueProcessor, TokenFactory tokenFactory) {
        this.optionalValueProcessor = optionalValueProcessor;
        this.tokenFactory = tokenFactory;
    }

    @PostMapping("/interbanking/refresh-token")
    public String refreshToken(String bank, @RequestParam(defaultValue = "") String ssn) {

        return tokenFactory.getService(optionalValueProcessor.getRequestParameterValue("bank", bank)).refreshAndGetToken(ssn);
    }
}
