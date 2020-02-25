package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.entity.payment.Payment;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

public interface PaymentService {

    Payment createPayment(String body) throws NoSuchFunctionalityException;

    String getBankId();
}
