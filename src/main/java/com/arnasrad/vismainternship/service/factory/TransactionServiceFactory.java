package com.arnasrad.vismainternship.service.factory;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.service.request.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceFactory {

    private List<TransactionService> transactionServiceList;

    public TransactionServiceFactory(List<TransactionService> paymentServiceList) {
        this.transactionServiceList = paymentServiceList;
    }

    public TransactionService getService(String bank) {
        return transactionServiceList.stream()
                .filter(transactionService -> transactionService.getBankId().equals(bank))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(ErrorMessages.WRONG_BANK));
    }
}
