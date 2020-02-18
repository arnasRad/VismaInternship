package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.model.payment.Payment;
import com.arnasrad.vismainternship.model.payment.Transaction;
import com.arnasrad.vismainternship.model.revolut.requestbody.CreatePaymentRequestBody;
import com.arnasrad.vismainternship.service.request.PaymentService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DNBPaymentService implements PaymentService {

    @Override
    public Payment createPayment(CreatePaymentRequestBody body) throws NoSuchFunctionalityException {

        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "createPayment"));
    }

    @Override
    public Transaction getTransaction(String id) throws NoSuchFunctionalityException {

        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "getTransaction"));
    }

    @Override
    public List<? extends Transaction> getTransactions(String counterparty, Date from, Date to, Integer count)
            throws NoSuchFunctionalityException {

        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "getTransactions"));
    }

    @Override
    public String getBankId() {

        return BankId.DNB_ID.getBank();
    }
}
