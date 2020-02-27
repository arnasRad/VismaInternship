package com.arnasrad.vismainternship.mapper.payment;

import com.arnasrad.vismainternship.model.dto.payment.PaymentRequestDTO;
import com.arnasrad.vismainternship.model.entity.payment.PaymentRequest;
import org.springframework.stereotype.Component;

@Component
public class PaymentRequestMapper {

    public PaymentRequest mapToEntity(PaymentRequestDTO dto) {
        return new PaymentRequest(dto.getRequestId(), dto.getState());
    }
}
