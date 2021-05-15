package com.hotelbeds.supplierintegrations.timetest.calculator.timeCalculator;

import org.springframework.stereotype.Service;

@Service
public interface TimeCalculator {

    long minutesBetweenTimestamps(String time1, String time2);

}
