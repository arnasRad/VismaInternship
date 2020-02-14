package com.arnasrad.vismainternship.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Component
public class OptionalValueProcessor {

    @Value("${error.msg.invalid-parameters}")
    private String invalidParametersError;

    public String getRequestParameterValue(String name, String value) {

        return Optional.ofNullable(value).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                String.format(invalidParametersError, name)));
    }
}
