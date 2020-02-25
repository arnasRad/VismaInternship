package com.arnasrad.vismainternship.mapper.payment;

import com.arnasrad.vismainternship.model.dto.payment.PaymentDTO;
import com.arnasrad.vismainternship.model.entity.payment.Payment;

public class PaymentMapper {

    public PaymentDTO mapToDTO(Payment entity) {
        return new PaymentDTO(entity.getPaymentId(), entity.getState(), entity.getCompletedAt());
    }

    public Payment mapToEntity(PaymentDTO dto) {
        return new Payment(dto.getId(), dto.getState(), dto.getCompletedAt());
    }
}
