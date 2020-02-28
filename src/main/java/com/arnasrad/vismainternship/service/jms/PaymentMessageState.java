package com.arnasrad.vismainternship.service.jms;

import com.arnasrad.vismainternship.mapper.PaymentRequestMapper;
import com.arnasrad.vismainternship.model.dto.payment.PaymentRequestDTO;
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

    public PaymentRequest mapAndSave(PaymentRequestDTO paymentRequestDTO, String state) {
        PaymentRequest paymentRequest = paymentRequestMapper.mapToEntity(paymentRequestDTO);
        paymentRequest.setState(state);
        return paymentRequestRepository.save(paymentRequest);
    }

    public PaymentRequest findAndUpdate(PaymentRequestDTO paymentRequestDTO, String state) throws EntryNotFoundException {
        PaymentRequest paymentRequest =
                paymentRequestRepository.findById(paymentRequestDTO.getRequestId())
                        .orElseThrow(() -> new EntryNotFoundException("PaymentRequest entry not found"));
        paymentRequest.setState(state);
        return paymentRequestRepository.save(paymentRequest);
    }

    public void update(PaymentRequest paymentRequest, String state) {
        paymentRequest.setState(state);
        paymentRequestRepository.save(paymentRequest);
    }
}
