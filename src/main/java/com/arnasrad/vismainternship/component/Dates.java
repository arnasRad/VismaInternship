package com.arnasrad.vismainternship.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class Dates {

    private final SimpleDateFormat simpleDateFormat;

    @Autowired
    public Dates(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }

    public String getFutureDateString(int daysFromToday) {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, daysFromToday);
        return simpleDateFormat.format(calendar.getTime());
    }

    public Date getFutureDate(int daysFromToday) {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, daysFromToday);
        return calendar.getTime();
    }
}
