package com.arnasrad.vismainternship.service.jms;

import com.arnasrad.vismainternship.model.dto.payment.PaymentRequestDTO;
import com.arnasrad.vismainternship.model.entity.payment.PaymentRequest;
import com.arnasrad.vismainternship.model.enums.MessageState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import java.util.UUID;

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

    public void send(String bank, PaymentRequestDTO body) {
        body.setBankId(bank);
        body.setRequestId(UUID.randomUUID().toString());
        PaymentRequest paymentRequest = paymentMessageState.mapDTOAndSave(body, MessageState.ACCEPTED.getState());
        logger.info("Payment request accepted");

        jmsTemplate.convertAndSend(paymentQueue, body);
        paymentMessageState.update(paymentRequest, MessageState.IN_QUEUE.getState());
        logger.info("Payment request in queue");
    }
}
