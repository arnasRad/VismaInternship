package com.arnasrad.vismainternship.service.dates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class DatesService {

    private static final Logger logger = LoggerFactory.getLogger(DatesService.class);
    private final SimpleDateFormat simpleDateFormat;

    public DatesService(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }

    public String getFutureDateString(int daysFromToday) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, daysFromToday);
        return simpleDateFormat.format(calendar.getTime());
    }

    public String getDateString(Date date) {
        return simpleDateFormat.format(date);
    }

    public Date getDate(String date) {
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            logger.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while parsing Date " +
                    "from String");
        }
    }
}
