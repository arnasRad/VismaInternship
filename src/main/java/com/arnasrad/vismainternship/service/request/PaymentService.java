package com.arnasrad.vismainternship.service.request;

import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.model.payment.Payment;
import com.arnasrad.vismainternship.model.payment.Transaction;
import com.arnasrad.vismainternship.model.revolut.requestbody.CreatePaymentRequestBody;

import java.util.Date;
import java.util.List;

public interface PaymentService {

    Payment createPayment(CreatePaymentRequestBody body) throws NoSuchFunctionalityException, BadRequestException;

    Transaction getTransaction(String id) throws NoSuchFunctionalityException, BadRequestException;

    List<? extends Transaction> getTransactions(String counterparty, Date from, Date to, Integer count) throws NoSuchFunctionalityException, BadRequestException;

    String getBankId();
}
