package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.model.dto.payment.PaymentDTO;
import com.arnasrad.vismainternship.model.dto.payment.PaymentRequestDTO;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.request.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class DNBPaymentService implements PaymentService {

    @Override
    public PaymentDTO createPayment(PaymentRequestDTO body) throws NoSuchFunctionalityException {
        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "createPayment"));
    }

    @Override
    public String getBankId() {
        return BankId.DNB_ID.getBank();
    }
}
