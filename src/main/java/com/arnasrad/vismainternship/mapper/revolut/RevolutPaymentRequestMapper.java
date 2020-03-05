package com.arnasrad.vismainternship.mapper.revolut;

import com.arnasrad.vismainternship.model.dto.PaymentAccountReference;
import com.arnasrad.vismainternship.model.dto.PaymentAmount;
import com.arnasrad.vismainternship.model.dto.PaymentRequestDto;
import com.arnasrad.vismainternship.model.dto.revolut.payment.PaymentReceiverDto;
import com.arnasrad.vismainternship.model.dto.revolut.payment.RevolutPaymentRequestDto;
import com.arnasrad.vismainternship.model.entity.payment.PaymentRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RevolutPaymentRequestMapper {

    public PaymentRequest mapToEntity(RevolutPaymentRequestDto dto) {
        PaymentRequest paymentRequest = new PaymentRequest();

        paymentRequest.setRequestId(dto.getRequestId());
        paymentRequest.setState(dto.getState());

        return paymentRequest;
    }

    public PaymentRequest mapToEntity(PaymentRequestDto dto) {
        PaymentRequest paymentRequest = new PaymentRequest();

        paymentRequest.setRequestId("TODO");
        paymentRequest.setState("TODO");

        return paymentRequest;
    }

    public RevolutPaymentRequestDto mapToRevolutPaymentRequestDto(PaymentRequestDto paymentRequestDto) {
        RevolutPaymentRequestDto revolutPaymentRequestDto = new RevolutPaymentRequestDto();

        revolutPaymentRequestDto.setAccountId(paymentRequestDto.getDebtor());
        revolutPaymentRequestDto.setReceiver(mapToPaymentReceiverDto(paymentRequestDto));
        mapInstructedAmountToRevolutRequest(revolutPaymentRequestDto, paymentRequestDto);
        revolutPaymentRequestDto.setReference(paymentRequestDto.getReference());

        return revolutPaymentRequestDto;
    }

    private PaymentReceiverDto mapToPaymentReceiverDto(PaymentRequestDto paymentRequestDto) {

        PaymentReceiverDto paymentReceiverDto = new PaymentReceiverDto();
        PaymentAccountReference creditor = paymentRequestDto.getCreditor();

        paymentReceiverDto.setAccountId(creditor.getIban());
        paymentReceiverDto.setCounterpartyId("TODO");
        return paymentReceiverDto;

    }

    private void mapInstructedAmountToRevolutRequest(RevolutPaymentRequestDto revolutPaymentRequestDto,
                                                     PaymentRequestDto paymentRequestDto) {
        PaymentAmount requestInstructedAmount = paymentRequestDto.getInstructedAmount();
        Double amount = Double.valueOf(requestInstructedAmount.getAmount());

        revolutPaymentRequestDto.setAmount(amount);
        revolutPaymentRequestDto.setCurrency(requestInstructedAmount.getCurrency());
    }
}
