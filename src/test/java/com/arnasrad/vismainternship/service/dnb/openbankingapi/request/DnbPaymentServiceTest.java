package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.dnb.psd2api.request.DnbPaymentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class DnbPaymentServiceTest {

    @InjectMocks
    private DnbPaymentService dnbPaymentService;

    @Test
    public void whenCreatePaymentCalled_thenNoSuchFunctionalityExceptionThrown() {
        assertThrows(NoSuchFunctionalityException.class, () -> dnbPaymentService.createPayment(null));
    }
}