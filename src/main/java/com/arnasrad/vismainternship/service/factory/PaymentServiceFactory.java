package com.arnasrad.vismainternship.service.factory;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.service.request.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentServiceFactory {

    private List<PaymentService> paymentServiceList;

    @Autowired
    public PaymentServiceFactory(List<PaymentService> paymentServiceList) {
        this.paymentServiceList = paymentServiceList;
    }

    public PaymentService getService(String bank) {

        return paymentServiceList.stream()
                .filter(paymentService -> paymentService.getBankId().equals(bank))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(ErrorMessages.WRONG_BANK));
    }
}
