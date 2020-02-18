package com.arnasrad.vismainternship.controller.interbankingapi;

import com.arnasrad.vismainternship.component.OptionalValueProcessor;
import com.arnasrad.vismainternship.model.interbankingapi.payment.Payment;
import com.arnasrad.vismainternship.model.interbankingapi.payment.Transaction;
import com.arnasrad.vismainternship.model.revolut.requestbody.CreatePaymentRequestBody;
import com.arnasrad.vismainternship.service.interbankingapi.factory.PaymentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController("interbanking-payment-controller")
public class PaymentController {

    private final OptionalValueProcessor optionalValueProcessor;
    private final PaymentFactory paymentFactory;

    @Autowired
    public PaymentController(OptionalValueProcessor optionalValueProcessor, PaymentFactory paymentFactory) {
        this.optionalValueProcessor = optionalValueProcessor;
        this.paymentFactory = paymentFactory;
    }

    @PostMapping("/interbanking/create-payment")
    public Payment createPayment(@RequestBody CreatePaymentRequestBody body, String bank) {

        return paymentFactory.getService(optionalValueProcessor.getRequestParameterValue("bank", bank)).createPayment(body);
    }

    @GetMapping("/interbanking/transaction")
    public Transaction getTransaction(String bank, String id) {

        return paymentFactory.getService(optionalValueProcessor.getRequestParameterValue("bank", bank)).getTransaction(id);
    }

    @GetMapping("/interbanking/transactions")
    public List<? extends Transaction> getTransaction(@RequestParam("bank") String bank,
                                                      @RequestParam("counterparty") String counterparty,
            @RequestParam("from") @DateTimeFormat(pattern =
            "yyyy-MM-dd") Date from, @RequestParam("to") @DateTimeFormat(pattern =
            "yyyy-MM-dd") Date to, @RequestParam("count") Integer count) {

        return paymentFactory.getService(optionalValueProcessor.getRequestParameterValue("bank", bank))
                .getTransactions(counterparty, from, to, count);
    }
}
