package com.arnasrad.vismainternship.service.dnb.request;

import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class DnbCounterpartyDtoServiceTest {

    @InjectMocks
    private DnbCounterpartyService dnbCounterpartyService;

    @Test
    public void whenGetCounterpartiesCalled_thenNoSuchFunctionalityExceptionThrown() {

        assertThrows(NoSuchFunctionalityException.class, () -> dnbCounterpartyService.getCounterparties());
    }
}