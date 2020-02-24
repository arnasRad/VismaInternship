package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.model.payment.Payment;

public interface PaymentService {

    Payment createPayment(String body) throws NoSuchFunctionalityException;

    String getBankId();
}
