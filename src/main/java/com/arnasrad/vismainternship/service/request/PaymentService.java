package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.dto.PaymentDto;
import com.arnasrad.vismainternship.model.dto.PaymentRequestDto;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;

public interface PaymentService {

    PaymentDto createPayment(PaymentRequestDto body) throws NoSuchFunctionalityException;

    String getBankId();
}
