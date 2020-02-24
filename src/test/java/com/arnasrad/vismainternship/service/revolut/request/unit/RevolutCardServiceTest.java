package com.arnasrad.vismainternship.service.revolut.request.unit;

import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.revolut.request.RevolutCardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
class RevolutCardServiceTest {

    @InjectMocks
    private RevolutCardService revolutCardService;

    @Test
    public void whenGetCardsCalled_thenNoSuchFunctionalityExceptionThrown() {

        assertThrows(NoSuchFunctionalityException.class, () -> revolutCardService.getCards());
    }

}