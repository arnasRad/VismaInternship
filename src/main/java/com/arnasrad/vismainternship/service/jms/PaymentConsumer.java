package com.arnasrad.vismainternship.service.jms;

import com.arnasrad.vismainternship.model.dto.payment.PaymentRequestDto;
import com.arnasrad.vismainternship.model.entity.payment.PaymentRequest;
import com.arnasrad.vismainternship.model.enums.MessageState;
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
    public void consume(PaymentRequestDto paymentRequestDTO)
            throws NoSuchFunctionalityException, EntryNotFoundException {
        PaymentRequest paymentRequest = paymentMessageState.findAndUpdate(paymentRequestDTO,
                MessageState.PROCESSING.getState());
        logger.info("Payment request processing");

        String bank = paymentRequestDTO.getBankId();
        PaymentService paymentService = paymentServiceFactory.getService(bank);

        paymentService.createPayment(paymentRequestDTO);
        paymentMessageState.update(paymentRequest, MessageState.PROCESSED.getState());
        logger.info("Payment request processed");
    }
}
