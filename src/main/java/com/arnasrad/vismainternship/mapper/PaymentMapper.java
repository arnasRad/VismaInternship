package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.payment.PaymentDto;
import com.arnasrad.vismainternship.model.dto.revolut.payment.RevolutPaymentDto;
import com.arnasrad.vismainternship.model.entity.payment.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public PaymentDto mapToPaymentDTO(Payment entity) {
        PaymentDto paymentDTO = new PaymentDto();

        paymentDTO.setId(entity.getPaymentId());
        paymentDTO.setState(entity.getState());
        paymentDTO.setCompletedAt(entity.getCompletedAt());

        return paymentDTO;
    }

    public RevolutPaymentDto mapToRevolutPaymentDTO(Payment entity) {
        RevolutPaymentDto revolutPaymentDTO = new RevolutPaymentDto();

        revolutPaymentDTO.setId(entity.getPaymentId());
        revolutPaymentDTO.setState(entity.getState());
        revolutPaymentDTO.setCompletedAt(entity.getCompletedAt());
        revolutPaymentDTO.setReasonCode(entity.getReasonCode());
        revolutPaymentDTO.setCreatedAt(entity.getCreatedAt());

        return revolutPaymentDTO;
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
