package com.arnasrad.vismainternship.component;

import com.arnasrad.vismainternship.service.interbankingapi.ResponseStatusExceptionBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OptionalValueProcessor {

    private final ResponseStatusExceptionBuilderService exceptionBuilder;

    @Autowired
    public OptionalValueProcessor(ResponseStatusExceptionBuilderService exceptionBuilder) {
        this.exceptionBuilder = exceptionBuilder;
    }

    public String getRequestParameterValue(String name, String value) {

        return Optional.ofNullable(value).orElseThrow(() -> exceptionBuilder.getInvalidParametersException400(name));
    }
}
