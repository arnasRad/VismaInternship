package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.mapper.TransactionMapper;
import com.arnasrad.vismainternship.model.dto.revolut.transaction.RevolutTransactionDto;
import com.arnasrad.vismainternship.model.entity.transaction.Transaction;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.persistence.transaction.TransactionRepository;
import com.arnasrad.vismainternship.service.request.TransactionService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestURLBuilderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class RevolutTransactionService implements TransactionService {

    private final RestTemplate restTemplate;
    private final RevolutRequestBuilderService revolutRequestBuilderService;
    private final RevolutRequestURLBuilderService revolutRequestURLBuilderService;
    private final TransactionRepository transactionRepository;
    private final TransactionMapper revolutTransactionMapper;
    @Value("${revolut.endpoint.transaction}")
    private String transactionEndpoint;

    public RevolutTransactionService(RestTemplate restTemplate,
                                     RevolutRequestBuilderService revolutRequestBuilderService,
                                     TransactionRepository transactionRepository,
                                     TransactionMapper revolutTransactionMapper,
                                     RevolutRequestURLBuilderService revolutRequestURLBuilderService) {
        this.restTemplate = restTemplate;
        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.transactionRepository = transactionRepository;
        this.revolutTransactionMapper = revolutTransactionMapper;
        this.revolutRequestURLBuilderService = revolutRequestURLBuilderService;
    }

    @Override
    public RevolutTransactionDto getTransaction(String id) {
        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getAuthorizedRequest();

        ResponseEntity<RevolutTransactionDto> responseEntity = restTemplate.exchange(transactionEndpoint.concat(id),
                HttpMethod.GET, authorizedHttpEntity, RevolutTransactionDto.class);

        return responseEntity.getBody();
    }

    @Override
    public List<RevolutTransactionDto> getTransactions(String counterparty, Date from, Date to, Integer count) {
        HttpEntity<String> authorizedHttpEntity = revolutRequestBuilderService.getAuthorizedRequest();

        String transactionsURI = revolutRequestURLBuilderService.getTransactionsURI(counterparty, from, to, count);

        ResponseEntity<List<RevolutTransactionDto>> responseEntity = restTemplate.exchange(transactionsURI,
                HttpMethod.GET, authorizedHttpEntity, new ParameterizedTypeReference<List<RevolutTransactionDto>>() {
                });

        return responseEntity.getBody();
    }


    @Override
    public String getBankId() {
        return BankId.REVOLUT_ID.getBank();
    }

    public void saveTransaction(String id) {
        RevolutTransactionDto transaction = getTransaction(id);
        Transaction revolutTransaction = revolutTransactionMapper.mapToTransactionEntity(transaction);
        transactionRepository.save(revolutTransaction);
    }

    public void setTransactionEndpoint(String transactionEndpoint) {
        this.transactionEndpoint = transactionEndpoint;
    }
}
