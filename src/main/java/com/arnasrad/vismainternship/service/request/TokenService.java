package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

public interface TokenService {

    String refreshAndGetToken(String ssn) throws NoSuchFunctionalityException, BadRequestException;

    String getBankId();
}
