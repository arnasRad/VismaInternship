package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

public interface TokenService {

    String refreshAndGetToken(String ssn) throws NoSuchFunctionalityException;

    String getBankId();
}
