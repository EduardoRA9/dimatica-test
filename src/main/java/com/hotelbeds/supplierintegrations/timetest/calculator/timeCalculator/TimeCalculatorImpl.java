package com.hotelbeds.supplierintegrations.timetest.calculator.timeCalculator;

import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Service
public class TimeCalculatorImpl implements TimeCalculator{
    @Override
    public long minutesBetweenTimestamps(String time1, String time2) {
        DateTimeFormatter dateFormat = DateTimeFormatter.RFC_1123_DATE_TIME;

        ZonedDateTime time1Zoned = ZonedDateTime.parse(time1, dateFormat);
        ZonedDateTime time2Zoned = ZonedDateTime.parse(time2, dateFormat);

        long minutesBetween = ChronoUnit.MINUTES.between(time1Zoned, time2Zoned);

        return minutesBetween > 0 ? minutesBetween : 0;
    }
}
