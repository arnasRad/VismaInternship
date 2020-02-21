package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class DNBAccountServiceTest {

    @InjectMocks
    private DNBAccountService dnbAccountService;

    @Test
    public void whenGetAccountsCalled_thenNoSuchFunctionalityExceptionThrown() {

        assertThrows(NoSuchFunctionalityException.class, () -> dnbAccountService.getAccounts());
    }

    @Test
    public void whenGetAccountCalled_thenNoSuchFunctionalityExceptionThrown() {

        assertThrows(NoSuchFunctionalityException.class, () -> dnbAccountService.getAccount(null));
    }

    @Test
    public void whenGetAccountDetailsCalled_thenNoSuchFunctionalityExceptionThrown() {

        assertThrows(NoSuchFunctionalityException.class, () -> dnbAccountService.getAccountDetails(null));
    }

}