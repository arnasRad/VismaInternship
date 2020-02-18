package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.model.revolut.requestbody.TransferRequestBody;
import com.arnasrad.vismainternship.service.interbankingapi.ResponseStatusExceptionBuilderService;
import com.arnasrad.vismainternship.service.interbankingapi.request.TransferService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class RevolutTransferService implements TransferService {

    @Value("${revolut.endpoint.transfer}")
    private String transferEndpoint;

    @Value("${constant.revolut-id-uppercase}")
    private String revolutId;

    private final RestTemplate restTemplate;
    private final RevolutRequestBuilderService revolutRequestBuilderService;
    private final ResponseStatusExceptionBuilderService exceptionBuilder;

    @Autowired
    public RevolutTransferService(RestTemplate restTemplate, RevolutRequestBuilderService revolutRequestBuilderService, ResponseStatusExceptionBuilderService exceptionBuilder) {

        this.restTemplate = restTemplate;
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.exceptionBuilder = exceptionBuilder;
    }

    @Override
    public String createTransfer(TransferRequestBody body) {

        return Optional.ofNullable(restTemplate.postForEntity(transferEndpoint,
                revolutRequestBuilderService.getTransferRequest(body), String.class).getBody())
                .orElseThrow(() -> exceptionBuilder.getException400("create-transfer"));
    }
}
