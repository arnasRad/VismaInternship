package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.model.dto.transaction.TransactionDto;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.factory.TransactionServiceFactory;
import com.arnasrad.vismainternship.service.request.TransactionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController("interbanking-transaction-controller")
public class TransactionController {

    private final TransactionServiceFactory transactionServiceFactory;

    public TransactionController(TransactionServiceFactory transactionServiceFactory) {
        this.transactionServiceFactory = transactionServiceFactory;
    }

    @GetMapping("/interbanking/transaction")
    public TransactionDto getTransactions(@RequestParam String bank, @RequestParam String id)
            throws NoSuchFunctionalityException {
        TransactionService service = transactionServiceFactory.getService(bank);
        return service.getTransaction(id);
    }

    @GetMapping("/interbanking/transactions")
    public List<? extends TransactionDto> getTransactions(@RequestParam String bank,
                                                          @RequestParam(required = false) String counterparty,
                                                          @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
                                                          @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date to,
                                                          @RequestParam(required = false) Integer count) throws NoSuchFunctionalityException {
        TransactionService service = transactionServiceFactory.getService(bank);
        return service.getTransactions(counterparty, from, to, count);
    }
}
