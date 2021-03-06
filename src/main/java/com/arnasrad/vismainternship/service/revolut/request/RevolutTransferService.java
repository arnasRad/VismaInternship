package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.service.request.TransferService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RevolutTransferService implements TransferService {

    private final RestTemplate restTemplate;
    private final RevolutRequestBuilderService revolutRequestBuilderService;
    @Value("${revolut.endpoint.transfer}")
    private String transferEndpoint;

    public RevolutTransferService(RestTemplate restTemplate, RevolutRequestBuilderService revolutRequestBuilderService) {
        this.restTemplate = restTemplate;
        this.revolutRequestBuilderService = revolutRequestBuilderService;
    }

    @Override
    public String createTransfer(String body) {
        JSONObject jsonObject = new JSONObject(body);
        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getAuthorizedJsonRequestWithBody(jsonObject);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(transferEndpoint, authorizedHttpEntity,
                String.class);

        return responseEntity.getBody();
    }

    public void setTransferEndpoint(String transferEndpoint) {
        this.transferEndpoint = transferEndpoint;
    }

    @Override
    public String getBankId() {
        return BankId.REVOLUT_ID.getBank();
    }
}
