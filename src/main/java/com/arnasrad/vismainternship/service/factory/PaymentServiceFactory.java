package com.arnasrad.vismainternship.service.factory;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.service.request.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceFactory {

    private List<PaymentService> paymentServiceList;

    public PaymentServiceFactory(List<PaymentService> paymentServiceList) {
        this.paymentServiceList = paymentServiceList;
    }

    public PaymentService getService(String bank) {
        return paymentServiceList.stream()
                .filter(transactionService -> transactionService.getBankId().equals(bank))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(ErrorMessages.WRONG_BANK));
    }
}
