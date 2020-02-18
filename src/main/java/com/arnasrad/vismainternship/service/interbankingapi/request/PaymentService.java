package com.arnasrad.vismainternship.service.interbankingapi.request;

import com.arnasrad.vismainternship.model.interbankingapi.payment.Payment;
import com.arnasrad.vismainternship.model.interbankingapi.payment.Transaction;
import com.arnasrad.vismainternship.model.revolut.requestbody.CreatePaymentRequestBody;

import java.util.Date;
import java.util.List;

public interface PaymentService {

    Payment createPayment(CreatePaymentRequestBody body);

    Transaction getTransaction(String id);

    List<? extends Transaction> getTransactions(String counterparty, Date from, Date to, Integer count);
}
