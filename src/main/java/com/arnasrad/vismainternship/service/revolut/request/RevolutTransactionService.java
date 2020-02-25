package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.model.dto.revolut.transaction.RevolutTransactionDTO;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.persistence.payment.TransactionRepository;
import com.arnasrad.vismainternship.service.request.TransactionService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class RevolutTransactionService implements TransactionService {

    private final RestTemplate restTemplate;
    private final RevolutRequestBuilderService revolutRequestBuilderService;
    private final TransactionRepository transactionRepository;
    @Value("${revolut.endpoint.transaction}")
    private String transactionEndpoint;
    @Value("${revolut.endpoint.transactions}")
    private String transactionsEndpoint;

    public RevolutTransactionService(RestTemplate restTemplate,
                                     RevolutRequestBuilderService revolutRequestBuilderService,
                                     TransactionRepository transactionRepository) {
        this.restTemplate = restTemplate;
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public RevolutTransactionDTO getTransaction(String id) {
        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<RevolutTransactionDTO> responseEntity = restTemplate.exchange(transactionEndpoint.concat(id),
                HttpMethod.GET, authorizedHttpEntity, RevolutTransactionDTO.class);

        return responseEntity.getBody();
    }

    @Override
    public List<RevolutTransactionDTO> getTransactions(String counterparty, Date from, Date to, Integer count) {
        HttpEntity<MultiValueMap<String, String>> authorizedHttpEntity =
                revolutRequestBuilderService.getTransactionsRequest(counterparty, from, to, count);

        ResponseEntity<List<RevolutTransactionDTO>> responseEntity = restTemplate.exchange(transactionsEndpoint,
                HttpMethod.GET, authorizedHttpEntity, new ParameterizedTypeReference<List<RevolutTransactionDTO>>() {
                });

        return responseEntity.getBody();
    }

    @Override
    public String getBankId() {
        return BankId.REVOLUT_ID.getBank();
    }

    public void saveTransaction(String id) {
        RevolutTransactionDTO transaction = getTransaction(id);
//        transactionRepository.save(transaction);
    }

    public void setTransactionEndpoint(String transactionEndpoint) {
        this.transactionEndpoint = transactionEndpoint;
    }

    public void setTransactionsEndpoint(String transactionsEndpoint) {
        this.transactionsEndpoint = transactionsEndpoint;
    }
}
