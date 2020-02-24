package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.model.payment.Payment;
import com.arnasrad.vismainternship.model.payment.Transaction;
import com.arnasrad.vismainternship.service.factory.PaymentServiceFactory;
import com.arnasrad.vismainternship.service.factory.TransactionServiceFactory;
import com.arnasrad.vismainternship.service.request.PaymentService;
import com.arnasrad.vismainternship.service.request.TransactionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController("interbanking-payment-controller")
public class PaymentController {

    private final PaymentServiceFactory paymentServiceFactory;
    private final TransactionServiceFactory transactionServiceFactory;

    public PaymentController(PaymentServiceFactory paymentServiceFactory,
                             TransactionServiceFactory transactionServiceFactory) {
        this.paymentServiceFactory = paymentServiceFactory;
        this.transactionServiceFactory = transactionServiceFactory;
    }

    @PostMapping("/interbanking/create-payment")
    public Payment createPayment(@RequestBody String body, @RequestParam String bank)
            throws NoSuchFunctionalityException {
        PaymentService service = paymentServiceFactory.getService(bank);
        return service.createPayment(body);
    }

    @GetMapping("/interbanking/transaction")
    public Transaction getTransactions(@RequestParam String bank, @RequestParam String id)
            throws NoSuchFunctionalityException {
        TransactionService service = transactionServiceFactory.getService(bank);
        return service.getTransaction(id);
    }

    @GetMapping("/interbanking/transactions")
    public List<? extends Transaction> getTransactions(@RequestParam String bank,
                                                       @RequestParam(required = false) String counterparty,
                                                       @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
                                                       @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date to,
                                                       @RequestParam(required = false) Integer count) throws NoSuchFunctionalityException {
        TransactionService service = transactionServiceFactory.getService(bank);
        return service.getTransactions(counterparty, from, to, count);
    }
}
