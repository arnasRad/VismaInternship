package com.arnasrad.vismainternship.service.jms;

import com.arnasrad.vismainternship.model.dto.payment.PaymentRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import java.util.UUID;

@Service
public class PaymentProducer {

    private static final Logger logger = LoggerFactory.getLogger(PaymentProducer.class);
    private final JmsTemplate jmsTemplate;
    private final Queue paymentQueue;

    public PaymentProducer(JmsTemplate jmsTemplate, Queue paymentQueue) {
        this.jmsTemplate = jmsTemplate;
        this.paymentQueue = paymentQueue;
    }

    public void send(String bank, PaymentRequestDTO body) {
        body.setBankId(bank);
        body.setRequestId(UUID.randomUUID().toString());
        jmsTemplate.convertAndSend(paymentQueue, body);
        logger.info("Payment request to bank '{}' sent ", bank);
    }
}
