package com.arnasrad.vismainternship.service.jms;

import com.arnasrad.vismainternship.model.dto.PaymentRequestDto;
import com.arnasrad.vismainternship.model.exception.EntryNotFoundException;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.factory.PaymentServiceFactory;
import com.arnasrad.vismainternship.service.request.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {

    private static final Logger logger = LoggerFactory.getLogger(PaymentConsumer.class);
    private final PaymentMessageState paymentMessageState;
    private final PaymentServiceFactory paymentServiceFactory;

    public PaymentConsumer(PaymentMessageState paymentMessageState, PaymentServiceFactory paymentServiceFactory) {
        this.paymentMessageState = paymentMessageState;
        this.paymentServiceFactory = paymentServiceFactory;
    }

    @JmsListener(destination = "#{@paymentQueueName}")
    public void consume(PaymentRequestDto paymentRequestDto)
            throws NoSuchFunctionalityException, EntryNotFoundException {
//        PaymentRequest paymentRequest = paymentMessageState.findAndUpdate(paymentRequestDto,
//                MessageState.PROCESSING.getState());
        logger.info("Payment request processing");

        String bank = paymentRequestDto.getBankName();
        PaymentService paymentService = paymentServiceFactory.getService(bank);

        paymentService.createPayment(paymentRequestDto);
//        paymentMessageState.update(paymentRequest, MessageState.PROCESSED.getState());
        logger.info("Payment request processed");
    }
}
