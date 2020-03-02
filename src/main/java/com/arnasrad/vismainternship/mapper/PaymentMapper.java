package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.payment.PaymentDto;
import com.arnasrad.vismainternship.model.dto.revolut.payment.RevolutPaymentDto;
import com.arnasrad.vismainternship.model.entity.payment.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public PaymentDto mapToPaymentDto(Payment entity) {
        PaymentDto paymentDto = new PaymentDto();

        paymentDto.setId(entity.getPaymentId());
        paymentDto.setState(entity.getState());
        paymentDto.setCompletedAt(entity.getCompletedAt());

        return paymentDto;
    }

    public RevolutPaymentDto mapToRevolutPaymentDto(Payment entity) {
        RevolutPaymentDto revolutPaymentDto = new RevolutPaymentDto();

        revolutPaymentDto.setId(entity.getPaymentId());
        revolutPaymentDto.setState(entity.getState());
        revolutPaymentDto.setCompletedAt(entity.getCompletedAt());
        revolutPaymentDto.setReasonCode(entity.getReasonCode());
        revolutPaymentDto.setCreatedAt(entity.getCreatedAt());

        return revolutPaymentDto;
    }

    public Payment mapToPaymentEntity(PaymentDto dto) {
        Payment payment = new Payment();

        payment.setPaymentId(dto.getId());
        payment.setState(dto.getState());
        payment.setCompletedAt(dto.getCompletedAt());

        return payment;
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
