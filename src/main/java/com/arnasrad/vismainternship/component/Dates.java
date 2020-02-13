package com.arnasrad.vismainternship.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
public class Dates {

    @Autowired
    private SimpleDateFormat simpleDateFormat;

    public String getFutureDateString(int daysFromToday) {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, daysFromToday);
        return simpleDateFormat.format(calendar.getTime());
    }
}
