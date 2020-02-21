package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class DNBPaymentServiceTest {

    @InjectMocks
    private DNBPaymentService dnbPaymentService;

    @Test
    public void whenCreatePaymentCalled_thenNoSuchFunctionalityExceptionThrown() {

        assertThrows(NoSuchFunctionalityException.class, () -> dnbPaymentService.createPayment(null));
    }

    @Test
    public void whenGetTransactionsCalled_thenNoSuchFunctionalityExceptionThrown() {

        assertThrows(NoSuchFunctionalityException.class, () ->
                dnbPaymentService.getTransactions(null, null, null, null));
    }

    @Test
    public void whenGetTransactionCalled_thenNoSuchFunctionalityExceptionThrown() {

        assertThrows(NoSuchFunctionalityException.class, () -> dnbPaymentService.getTransaction(null));
    }
}