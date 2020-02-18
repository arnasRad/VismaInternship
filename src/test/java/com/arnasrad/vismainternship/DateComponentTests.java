package com.arnasrad.vismainternship;

import com.arnasrad.vismainternship.service.dates.DatesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@AutoConfigureMockMvc
public class DateComponentTests {

    private final DatesService datesService;
    private final SimpleDateFormat simpleDateFormat;

    @Autowired
    public DateComponentTests(DatesService datesService, SimpleDateFormat simpleDateFormat) {
        this.datesService = datesService;
        this.simpleDateFormat = simpleDateFormat;
    }

    @Test
    public void whenGetFutureDate_thenReturnFutureDateString() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        String expectedFutureDate = simpleDateFormat.format(calendar.getTime());

        String actualFutureDate = datesService.getFutureDateString(5);
        assertEquals(expectedFutureDate, actualFutureDate);
    }

}
