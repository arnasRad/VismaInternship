package com.arnasrad.vismainternship.service.jms;

import com.arnasrad.vismainternship.model.dto.payment.PaymentRequestDTO;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.factory.PaymentServiceFactory;
import com.arnasrad.vismainternship.service.request.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {

    @Value("${jms.queues.payment}")
    private String paymentQueueName;
    private static final Logger logger = LoggerFactory.getLogger(PaymentConsumer.class);
    private final PaymentServiceFactory paymentServiceFactory;

    public PaymentConsumer(PaymentServiceFactory paymentServiceFactory) {
        this.paymentServiceFactory = paymentServiceFactory;
    }

    @JmsListener(destination = "#{@paymentQueueName}")
    public void consume(PaymentRequestDTO paymentRequestDTO) throws NoSuchFunctionalityException {
        String bank = paymentRequestDTO.getBankId();
        PaymentService paymentService = paymentServiceFactory.getService(bank);

        paymentService.createPayment(paymentRequestDTO);

        logger.info("Payment request to bank '{}' consumed", bank);
    }
}
