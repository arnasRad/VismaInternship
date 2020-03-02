package com.arnasrad.vismainternship.service.jms;

import com.arnasrad.vismainternship.mapper.PaymentRequestMapper;
import com.arnasrad.vismainternship.model.dto.payment.PaymentRequestDto;
import com.arnasrad.vismainternship.model.entity.payment.PaymentRequest;
import com.arnasrad.vismainternship.model.exception.EntryNotFoundException;
import com.arnasrad.vismainternship.persistence.payment.PaymentRequestRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentMessageState {

    private final PaymentRequestMapper paymentRequestMapper;
    private final PaymentRequestRepository paymentRequestRepository;

    public PaymentMessageState(PaymentRequestMapper paymentRequestMapper, PaymentRequestRepository paymentRequestRepository) {
        this.paymentRequestMapper = paymentRequestMapper;
        this.paymentRequestRepository = paymentRequestRepository;
    }

    public PaymentRequest mapAndSave(PaymentRequestDto paymentRequestDto, String state) {
        PaymentRequest paymentRequest = paymentRequestMapper.mapToEntity(paymentRequestDto);
        paymentRequest.setState(state);
        return paymentRequestRepository.save(paymentRequest);
    }

    public PaymentRequest findAndUpdate(PaymentRequestDto paymentRequestDto, String state) throws EntryNotFoundException {
        PaymentRequest paymentRequest =
                paymentRequestRepository.findById(paymentRequestDto.getRequestId())
                        .orElseThrow(() -> new EntryNotFoundException("PaymentRequest entry not found"));
        paymentRequest.setState(state);
        return paymentRequestRepository.save(paymentRequest);
    }

    public void update(PaymentRequest paymentRequest, String state) {
        paymentRequest.setState(state);
        paymentRequestRepository.save(paymentRequest);
    }
}
