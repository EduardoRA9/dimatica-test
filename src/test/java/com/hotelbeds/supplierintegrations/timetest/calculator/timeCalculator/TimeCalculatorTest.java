package com.hotelbeds.supplierintegrations.timetest.calculator.timeCalculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TimeCalculatorTest {

    @Autowired
    TimeCalculator timeCalculator;

    @Test
    public void time1AfterTime2SameTimeZone() {
        String time1 = "Thu, 21 Dec 2000 18:15:00 +0200";
        String time2 = "Thu, 21 Dec 2000 16:00:30 +0200";
        Assert.assertEquals(timeCalculator.minutesBetweenTimestamps(time1,time2), 0);
    }

    @Test
    public void time1BeforeTime2SameTimeZone() {
        String time1 = "Thu, 21 Dec 2000 16:00:30 +0200";
        String time2 = "Thu, 21 Dec 2000 18:15:00 +0200";
        Assert.assertEquals(timeCalculator.minutesBetweenTimestamps(time1,time2), 134);
    }

    @Test
    public void time1AfterTime2DifferentTimeZone() {
        String time1 = "Thu, 21 Dec 2000 18:15:00 +0300";
        String time2 = "Thu, 21 Dec 2000 16:00:30 +0200";
        Assert.assertEquals(timeCalculator.minutesBetweenTimestamps(time1,time2), 0);
    }

    @Test
    public void time1BeforeTime2DifferentTimeZone() {
        String time1 = "Thu, 21 Dec 2000 16:00:30 +0200";
        String time2 = "Thu, 21 Dec 2000 18:15:00 +0300";
        Assert.assertEquals(timeCalculator.minutesBetweenTimestamps(time1,time2), 74);
    }
}
