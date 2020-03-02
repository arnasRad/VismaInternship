package com.arnasrad.vismainternship.service.dnb.psd2api.request;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.model.dto.payment.PaymentDto;
import com.arnasrad.vismainternship.model.dto.payment.PaymentRequestDto;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.request.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class DnbPaymentService implements PaymentService {

    @Override
    public PaymentDto createPayment(PaymentRequestDto body) throws NoSuchFunctionalityException {
        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "createPayment"));
    }

    @Override
    public String getBankId() {
        return BankId.DNB_ID.getBank();
    }
}