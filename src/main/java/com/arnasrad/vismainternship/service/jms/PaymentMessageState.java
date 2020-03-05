package com.arnasrad.vismainternship.service.jms;

import com.arnasrad.vismainternship.mapper.revolut.RevolutPaymentRequestMapper;
import com.arnasrad.vismainternship.model.dto.PaymentRequestDto;
import com.arnasrad.vismainternship.model.dto.revolut.payment.RevolutPaymentRequestDto;
import com.arnasrad.vismainternship.model.entity.payment.PaymentRequest;
import com.arnasrad.vismainternship.model.exception.EntryNotFoundException;
import com.arnasrad.vismainternship.persistence.payment.PaymentRequestRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentMessageState {

//    private final RevolutPaymentRequestMapper revolutPaymentRequestMapper;
//    private final PaymentRequestRepository paymentRequestRepository;
//
//    public PaymentMessageState(RevolutPaymentRequestMapper revolutPaymentRequestMapper, PaymentRequestRepository paymentRequestRepository) {
//        this.revolutPaymentRequestMapper = revolutPaymentRequestMapper;
//        this.paymentRequestRepository = paymentRequestRepository;
//    }
//
//    public PaymentRequest mapAndSave(PaymentRequestDto paymentRequestDto, String state) {
//        PaymentRequest paymentRequest = revolutPaymentRequestMapper.mapToEntity(paymentRequestDto);
//        paymentRequest.setState(state);
//        return paymentRequestRepository.save(paymentRequest);
//    }
//
//    public PaymentRequest findAndUpdate(PaymentRequestDto paymentRequestDto, String state) throws EntryNotFoundException {
//        PaymentRequest paymentRequest =
//                paymentRequestRepository.findById(paymentRequestDto.getId())
//                        .orElseThrow(() -> new EntryNotFoundException("PaymentRequest entry not found"));
//        paymentRequest.setState(state);
//        return paymentRequestRepository.save(paymentRequest);
//    }
//
//    public void update(PaymentRequest paymentRequest, String state) {
//        paymentRequest.setState(state);
//        paymentRequestRepository.save(paymentRequest);
//    }
}
