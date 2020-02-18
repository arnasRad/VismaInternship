package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.model.payment.Payment;
import com.arnasrad.vismainternship.model.payment.Transaction;
import com.arnasrad.vismainternship.model.revolut.requestbody.CreatePaymentRequestBody;
import com.arnasrad.vismainternship.service.factory.PaymentServiceFactory;
import com.arnasrad.vismainternship.service.request.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController("interbanking-payment-controller")
public class PaymentController {

    private final PaymentServiceFactory paymentServiceFactory;

    @Autowired
    public PaymentController(PaymentServiceFactory paymentServiceFactory) {

        this.paymentServiceFactory = paymentServiceFactory;
    }

    @PostMapping("/interbanking/create-payment")
    public Payment createPayment(@RequestBody CreatePaymentRequestBody body, @RequestParam String bank)
            throws BadRequestException, NoSuchFunctionalityException {

        return paymentServiceFactory.getService(bank).createPayment(body);
    }

    @GetMapping("/interbanking/transaction")
    public Transaction getTransaction(@RequestParam String bank, @RequestParam String id)
            throws BadRequestException, NoSuchFunctionalityException {

        return paymentServiceFactory.getService(bank).getTransaction(id);
    }

    @GetMapping("/interbanking/transactions")
    public List<? extends Transaction> getTransaction(@RequestParam String bank,
              @RequestParam(required = false) String counterparty,
              @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
              @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date to,
              @RequestParam(required = false) Integer count) throws BadRequestException, NoSuchFunctionalityException {

        PaymentService service = paymentServiceFactory.getService(bank);
        return service.getTransactions(counterparty, from, to, count);
    }
}
