package com.arnasrad.vismainternship.mapper.revolut;

import com.arnasrad.vismainternship.model.dto.PaymentDto;
import com.arnasrad.vismainternship.model.dto.PaymentRequestDto;
import com.arnasrad.vismainternship.model.dto.revolut.payment.PaymentReceiverDto;
import com.arnasrad.vismainternship.model.dto.revolut.payment.RevolutPaymentDto;
import com.arnasrad.vismainternship.model.dto.revolut.payment.RevolutPaymentRequestDto;
import com.arnasrad.vismainternship.model.entity.payment.Payment;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RevolutPaymentMapper {

    public RevolutPaymentDto mapToRevolutPaymentDto(Payment entity) {
        RevolutPaymentDto revolutPaymentDto = new RevolutPaymentDto();

        revolutPaymentDto.setId(entity.getPaymentId());
        revolutPaymentDto.setState(entity.getState());
        revolutPaymentDto.setCompletedAt(entity.getCompletedAt());
        revolutPaymentDto.setReasonCode(entity.getReasonCode());
        revolutPaymentDto.setCreatedAt(entity.getCreatedAt());

        return revolutPaymentDto;
    }

    public PaymentDto mapToPaymentDto(RevolutPaymentDto revolutPaymentDto) {
        PaymentDto paymentDto = new PaymentDto();

        paymentDto.setId(revolutPaymentDto.getId());
        paymentDto.setState(revolutPaymentDto.getState());

        return paymentDto;
    }

    public Payment mapToPaymentEntity(RevolutPaymentDto dto) {
        Payment payment = new Payment();

        payment.setPaymentId(dto.getId());
        payment.setState(dto.getState());
        payment.setReasonCode(dto.getReasonCode());
        payment.setCreatedAt(dto.getCreatedAt());
        payment.setCompletedAt(dto.getCompletedAt());

        return payment;
    }
}
