package com.tw.lane.bcc.common;

import org.joda.time.DateTime;

/**
 * Created by luchen on 15/10/2016.
 */
public class Discount {
    private DateTime startDate;
    private DateTime endDate;
    private float rate;

    public Discount(DateTime startDate, DateTime endDate, float rate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.rate = rate;
    }

    public boolean isValid(DateTime dateTime) {
        return startDate.isBefore(dateTime.toInstant()) && endDate.plusDays(1).isAfter(dateTime.toInstant());
    }

    public float getRate() {
        return rate;
    }
}
