package com.arnasrad.vismainternship.mapper.dnb;

import com.arnasrad.vismainternship.model.dto.PaymentAccountReference;
import com.arnasrad.vismainternship.model.dto.PaymentAmount;
import com.arnasrad.vismainternship.model.dto.PaymentRequestDto;
import com.arnasrad.vismainternship.model.dto.dnb.payment.AccountReference;
import com.arnasrad.vismainternship.model.dto.dnb.payment.Amount;
import com.arnasrad.vismainternship.model.dto.dnb.payment.DnbPaymentRequestDto;
import org.springframework.stereotype.Component;

@Component
public class DnbPaymentRequestMapper {

    public DnbPaymentRequestDto mapToDnbPaymentRequestDto(PaymentRequestDto paymentRequestDto) {
        DnbPaymentRequestDto dnbPaymentRequestDto = new DnbPaymentRequestDto();

        dnbPaymentRequestDto.setDebtorAccount(mapRequestToDebtorAccount(paymentRequestDto));
        dnbPaymentRequestDto.setCreditorAccount(mapRequestToCreditorAccount(paymentRequestDto));
        dnbPaymentRequestDto.setCreditorName(paymentRequestDto.getCreditor().getName());
        dnbPaymentRequestDto.setInstructedAmount(mapRequestToInstructedAmount(paymentRequestDto));
        dnbPaymentRequestDto.setRemittanceInformationUnstructured(paymentRequestDto.getReference());

        return dnbPaymentRequestDto;
    }

    private AccountReference mapRequestToCreditorAccount(PaymentRequestDto paymentRequestDto) {
        AccountReference creditorAccount = new AccountReference();
        PaymentAccountReference creditor = paymentRequestDto.getCreditor();

        creditorAccount.setBban(creditor.getIban());
        return creditorAccount;
    }

    private Amount mapRequestToInstructedAmount(PaymentRequestDto paymentRequestDto) {
        Amount instructedAmount = new Amount();
        PaymentAmount requestInstructedAmount = paymentRequestDto.getInstructedAmount();

        instructedAmount.setAmount(requestInstructedAmount.getAmount());
        instructedAmount.setCurrency(requestInstructedAmount.getCurrency());
        return instructedAmount;
    }

    private AccountReference mapRequestToDebtorAccount(PaymentRequestDto paymentRequestDto) {
        AccountReference debtorAccount = new AccountReference();
        debtorAccount.setBban(paymentRequestDto.getDebtor());
        return debtorAccount;
    }
}
