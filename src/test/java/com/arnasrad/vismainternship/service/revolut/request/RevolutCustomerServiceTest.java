package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
class RevolutCustomerServiceTest {

    @InjectMocks
    private RevolutCustomerService revolutCustomerService;

    @Test
    public void whenGetCustomersCalled_thenNoSuchFunctionalityExceptionThrown() {

        assertThrows(NoSuchFunctionalityException.class, () -> revolutCustomerService.getCustomers());
    }

    @Test
    public void whenGetCurrentCustomerInfoCalled_thenNoSuchFunctionalityExceptionThrown() {

        assertThrows(NoSuchFunctionalityException.class, () -> revolutCustomerService.getCurrentCustomerInfo());
    }

    @Test
    public void whenGetCustomerInfoCalled_thenNoSuchFunctionalityExceptionThrown() {

        assertThrows(NoSuchFunctionalityException.class, () -> revolutCustomerService.getCustomerInfo(null));
    }

}