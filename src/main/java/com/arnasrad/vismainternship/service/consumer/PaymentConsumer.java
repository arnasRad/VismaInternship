package com.arnasrad.vismainternship.service.consumer;

import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.factory.PaymentServiceFactory;
import com.arnasrad.vismainternship.service.request.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
public class PaymentConsumer {

    private static final Logger logger = LoggerFactory.getLogger(PaymentConsumer.class);
    private final PaymentServiceFactory paymentServiceFactory;

    public PaymentConsumer(PaymentServiceFactory paymentServiceFactory) {
        this.paymentServiceFactory = paymentServiceFactory;
    }

    @JmsListener(destination = "queues.payment")
    public void consume(MultiValueMap<String, String> requestMap) throws NoSuchFunctionalityException {
        String bank = requestMap.getFirst("bank");
        PaymentService paymentService = paymentServiceFactory.getService(bank);

        String requestBody = requestMap.getFirst("body");
        paymentService.createPayment(requestBody);

        logger.info("Payment request to bank '{}' consumed", bank);
    }
}
