package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.dto.payment.PaymentDTO;
import com.arnasrad.vismainternship.model.dto.payment.PaymentRequestDTO;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

public interface PaymentService {

    PaymentDTO createPayment(PaymentRequestDTO body) throws NoSuchFunctionalityException;

    String getBankId();
}
