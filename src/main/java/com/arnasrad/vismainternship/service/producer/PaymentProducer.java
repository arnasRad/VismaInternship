package com.arnasrad.vismainternship.service.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.jms.Queue;

@Service
public class PaymentProducer {

    private static final Logger logger = LoggerFactory.getLogger(PaymentProducer.class);
    private final JmsTemplate jmsTemplate;
    private final Queue transactionQueue;

    public PaymentProducer(JmsTemplate jmsTemplate, Queue transactionQueue) {
        this.jmsTemplate = jmsTemplate;
        this.transactionQueue = transactionQueue;
    }

    public void send(String bank, String body) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("bank", bank);
        map.add("body", body);
        jmsTemplate.convertAndSend(transactionQueue, map);
        logger.info("Payment request to bank '{}' sent ", bank);
    }
}
