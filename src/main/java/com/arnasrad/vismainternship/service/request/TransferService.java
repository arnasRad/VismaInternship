package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

public interface TransferService {

    String createTransfer(String body) throws NoSuchFunctionalityException;

    String getBankId();
}
