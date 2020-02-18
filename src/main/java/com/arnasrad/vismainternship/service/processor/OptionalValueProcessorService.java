package com.arnasrad.vismainternship.service.processor;

import com.arnasrad.vismainternship.model.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class OptionalValueProcessorService {

    public String getRequestParameterValue(String name, String value) {

        return Optional.ofNullable(value).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                        String.format(ErrorMessages.INVALID_PARAMETERS, name)));
    }
}
