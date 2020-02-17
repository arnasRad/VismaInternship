package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.revolut.requestbody.TransferRequestBody;

public interface TransferService {

    String createTransfer(TransferRequestBody body);
}
