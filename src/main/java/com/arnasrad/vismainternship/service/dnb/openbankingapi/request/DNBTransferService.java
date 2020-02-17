package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import com.arnasrad.vismainternship.model.revolut.requestbody.TransferRequestBody;
import com.arnasrad.vismainternship.service.ResponseStatusExceptionBuilderService;
import com.arnasrad.vismainternship.service.request.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DNBTransferService implements TransferService {

    @Value("${constant.dnb-id-uppercase}")
    private String dnbId;

    private final ResponseStatusExceptionBuilderService exceptionBuilder;

    @Autowired
    public DNBTransferService(ResponseStatusExceptionBuilderService exceptionBuilder) {

        this.exceptionBuilder = exceptionBuilder;
    }

    @Override
    public String createTransfer(TransferRequestBody body) {

        throw exceptionBuilder.getNoFunctionalityException400(dnbId, "createTransfer");
    }
}
