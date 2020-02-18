package com.arnasrad.vismainternship.service.interbankingapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ResponseStatusExceptionBuilderService {

    @Value("${error.msg.no-functionality}")
    private String noFunctionalityMsg;

    @Value("${error.msg.bad-request}")
    private String badRequestMsg;

    @Value("${error.msg.invalid-parameters}")
    private String invalidParametersError;

    @Value("${error.msg.wrong-bank}")
    private String wrongBankMsg;

    @Value("${error.msg.json-mapper}")
    private String jsonResponseError;

    public ResponseStatusException getNoFunctionalityException400(String bankId, String functionalityName) {

        return new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(noFunctionalityMsg, bankId,
                functionalityName));
    }

    public ResponseStatusException getException400(String requestName) {

        return new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(badRequestMsg,
                requestName));
    }

    public ResponseStatusException getInvalidParametersException400(String parameterName) {

        return new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(invalidParametersError,
                parameterName));
    }

    public ResponseStatusException getWrongBankException400() {

        return new ResponseStatusException(HttpStatus.BAD_REQUEST, wrongBankMsg);
    }

    public ResponseStatusException getJsonException500() {

        return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, jsonResponseError);
    }
}
