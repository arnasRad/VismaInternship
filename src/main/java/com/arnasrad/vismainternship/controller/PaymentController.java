package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.model.payment.Payment;
import com.arnasrad.vismainternship.model.payment.Transaction;
import com.arnasrad.vismainternship.model.revolut.requestbody.CreatePaymentRequestBody;
import com.arnasrad.vismainternship.service.factory.PaymentServiceFactory;
import com.arnasrad.vismainternship.service.processor.OptionalValueProcessorService;
import com.arnasrad.vismainternship.service.request.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController("interbanking-payment-controller")
public class PaymentController {

    private final OptionalValueProcessorService optionalValueProcessorService;
    private final PaymentServiceFactory paymentServiceFactory;

    @Autowired
    public PaymentController(OptionalValueProcessorService optionalValueProcessorService, PaymentServiceFactory paymentServiceFactory) {
        this.optionalValueProcessorService = optionalValueProcessorService;
        this.paymentServiceFactory = paymentServiceFactory;
    }

    @PostMapping("/interbanking/create-payment")
    public Payment createPayment(@RequestBody CreatePaymentRequestBody body, @RequestParam String bank)
            throws BadRequestException, NoSuchFunctionalityException {

        return paymentServiceFactory.getService(optionalValueProcessorService.getRequestParameterValue("bank", bank)).createPayment(body);
    }

    @GetMapping("/interbanking/transaction")
    public Transaction getTransaction(@RequestParam String bank, @RequestParam String id)
            throws BadRequestException, NoSuchFunctionalityException {

        return paymentServiceFactory.getService(optionalValueProcessorService.getRequestParameterValue("bank", bank)).getTransaction(id);
    }

    @GetMapping("/interbanking/transactions")
    public List<? extends Transaction> getTransaction(@RequestParam String bank,
              @RequestParam(required = false) String counterparty,
              @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
              @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date to,
              @RequestParam(required = false) Integer count) throws BadRequestException, NoSuchFunctionalityException {

        String bankParam = optionalValueProcessorService.getRequestParameterValue("bank", bank);
        PaymentService service = paymentServiceFactory.getService(bankParam);
        return service.getTransactions(counterparty, from, to, count);
    }
}
