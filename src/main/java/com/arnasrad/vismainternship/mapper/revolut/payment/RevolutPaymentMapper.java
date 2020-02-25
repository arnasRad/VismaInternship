package com.arnasrad.vismainternship.mapper.revolut.payment;

import com.arnasrad.vismainternship.model.dto.revolut.payment.RevolutPaymentDTO;
import com.arnasrad.vismainternship.model.entity.revolut.payment.RevolutPayment;


public class RevolutPaymentMapper {

    public RevolutPaymentDTO mapToDTO(RevolutPayment entity) {
        return new RevolutPaymentDTO(entity.getPaymentId(), entity.getState(), entity.getCompletedAt(),
                entity.getReasonCode(), entity.getCreatedAt());
    }

    public RevolutPayment mapToEntity(RevolutPaymentDTO dto) {
        return new RevolutPayment(dto.getId(), dto.getState(), dto.getCompletedAt(), dto.getReasonCode(),
                dto.getCreatedAt());
    }
}
