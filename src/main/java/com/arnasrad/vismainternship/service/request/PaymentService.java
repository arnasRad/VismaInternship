package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.Payment;
import com.arnasrad.vismainternship.model.revolut.requestbody.CreatePaymentRequestBody;

public interface PaymentService {

    Payment createPayment(CreatePaymentRequestBody body);
}
