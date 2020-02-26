package com.arnasrad.vismainternship.mapper.revolut.payment;

import com.arnasrad.vismainternship.model.dto.revolut.payment.RevolutPaymentDTO;
import com.arnasrad.vismainternship.model.entity.payment.Payment;
import org.springframework.stereotype.Component;

@Component
public class RevolutPaymentMapper {

    public RevolutPaymentDTO mapToDTO(Payment entity) {
        return new RevolutPaymentDTO(entity.getPaymentId(), entity.getState(), entity.getCompletedAt(),
                entity.getReasonCode(), entity.getCreatedAt());
    }

    public Payment mapToEntity(RevolutPaymentDTO dto) {
        return new Payment(dto.getId(), dto.getState(), dto.getReasonCode(), dto.getCreatedAt(), dto.getCompletedAt());
    }
}
