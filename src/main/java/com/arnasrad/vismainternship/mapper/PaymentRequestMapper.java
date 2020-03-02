package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.payment.PaymentRequestDto;
import com.arnasrad.vismainternship.model.entity.payment.PaymentRequest;
import org.springframework.stereotype.Component;

@Component
public class PaymentRequestMapper {

    public PaymentRequest mapToEntity(PaymentRequestDto dto) {
        PaymentRequest paymentRequest = new PaymentRequest();

        paymentRequest.setRequestId(dto.getRequestId());
        paymentRequest.setState(dto.getState());

        return paymentRequest;
    }
}
