package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.factory.TokenServiceFactory;
import com.arnasrad.vismainternship.service.processor.OptionalValueProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("interbanking-token-controller")
public class TokenController {

    private final OptionalValueProcessorService optionalValueProcessorService;
    private final TokenServiceFactory tokenServiceFactory;

    @Autowired
    public TokenController(OptionalValueProcessorService optionalValueProcessorService, TokenServiceFactory tokenServiceFactory) {
        this.optionalValueProcessorService = optionalValueProcessorService;
        this.tokenServiceFactory = tokenServiceFactory;
    }

    @PostMapping("/interbanking/refresh-token")
    public String refreshToken(@RequestParam String bank, @RequestParam(defaultValue = "") String ssn) throws BadRequestException, NoSuchFunctionalityException {

        return tokenServiceFactory.getService(optionalValueProcessorService.getRequestParameterValue("bank", bank)).refreshAndGetToken(ssn);
    }
}
