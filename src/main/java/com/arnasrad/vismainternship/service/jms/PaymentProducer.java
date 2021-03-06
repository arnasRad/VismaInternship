package com.arnasrad.vismainternship.service.jms;

import com.arnasrad.vismainternship.model.dto.PaymentRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
public class PaymentProducer {

    private static final Logger logger = LoggerFactory.getLogger(PaymentProducer.class);
    private final PaymentMessageState paymentMessageState;
    private final JmsTemplate jmsTemplate;
    private final Queue paymentQueue;

    public PaymentProducer(PaymentMessageState paymentMessageState, JmsTemplate jmsTemplate, Queue paymentQueue) {
        this.paymentMessageState = paymentMessageState;
        this.jmsTemplate = jmsTemplate;
        this.paymentQueue = paymentQueue;
    }

    public void send(PaymentRequestDto body) {
//        PaymentRequest paymentRequest = paymentMessageState.mapAndSave(body, MessageState.ACCEPTED.getState());
        logger.info("Payment request accepted");

        jmsTemplate.convertAndSend(paymentQueue, body);
//        paymentMessageState.update(paymentRequest, MessageState.IN_QUEUE.getState());
        logger.info("Payment request in queue");
    }
}
