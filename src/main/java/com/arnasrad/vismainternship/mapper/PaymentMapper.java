package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.payment.PaymentDTO;
import com.arnasrad.vismainternship.model.dto.revolut.payment.RevolutPaymentDTO;
import com.arnasrad.vismainternship.model.entity.payment.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public PaymentDTO mapToPaymentDTO(Payment entity) {
        PaymentDTO paymentDTO = new PaymentDTO();

        paymentDTO.setId(entity.getPaymentId());
        paymentDTO.setState(entity.getState());
        paymentDTO.setCompletedAt(entity.getCompletedAt());

        return paymentDTO;
    }

    public RevolutPaymentDTO mapToRevolutPaymentDTO(Payment entity) {
        RevolutPaymentDTO revolutPaymentDTO = new RevolutPaymentDTO();

        revolutPaymentDTO.setId(entity.getPaymentId());
        revolutPaymentDTO.setState(entity.getState());
        revolutPaymentDTO.setCompletedAt(entity.getCompletedAt());
        revolutPaymentDTO.setReasonCode(entity.getReasonCode());
        revolutPaymentDTO.setCreatedAt(entity.getCreatedAt());

        return revolutPaymentDTO;
    }

    public Payment mapToPaymentEntity(PaymentDTO dto) {
        Payment payment = new Payment();

        payment.setPaymentId(dto.getId());
        payment.setState(dto.getState());
        payment.setCompletedAt(dto.getCompletedAt());

        return payment;
    }

    public Payment mapToPaymentEntity(RevolutPaymentDTO dto) {
        Payment payment = new Payment();

        payment.setPaymentId(dto.getId());
        payment.setState(dto.getState());
        payment.setReasonCode(dto.getReasonCode());
        payment.setCreatedAt(dto.getCreatedAt());
        payment.setCompletedAt(dto.getCompletedAt());

        return payment;
    }
}
