package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.payment.PaymentRequestDto;
import com.arnasrad.vismainternship.model.entity.payment.PaymentRequest;
import org.springframework.stereotype.Component;

@Component
public class PaymentRequestMapper {

    public PaymentRequest mapToEntity(PaymentRequestDto dto) {
        return new PaymentRequest(dto.getRequestId(), dto.getState());
    }
}
