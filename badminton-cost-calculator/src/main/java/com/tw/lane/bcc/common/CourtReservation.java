package com.tw.lane.bcc.common;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

import java.util.List;

/**
 * Created by luchen on 13/10/2016.
 */
public class CourtReservation {
    private DateTime startTime;
    private DateTime endTime;
    private int peopleCount;
    private int costSum;
    private int chargeSum;

    public int getCourtReserved() {
        return courtReserved;
    }

    private int courtReserved;

    public CourtReservation(int year, int month, int day, int starHoursOfDay, int endHoursOfDay, int peopleCount) {
        this.startTime = new DateTime(year, month, day, starHoursOfDay, 0);
        this.endTime = new DateTime(year, month, day, endHoursOfDay, 0);
        this.peopleCount = peopleCount;
        this.courtReserved = reserveCourt();
    }

    private int reserveCourt() {
        int court = peopleCount / 6;
        int rest = peopleCount % 6;
        if(rest == 0) {
            return court;
        }
        if(court == 0 && rest < 4) {
            return court;
        }
        if(court == 0 && rest >=4) {
            return court + 1;
        }
        if(court == 1) {
            return court + 1;
        }
        if(court <= 3 ) {
            if(rest >= 4) {
                return court + 1;
            } else {
                return court;
            }
        }
        return court;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public int getCostSum() {
        return costSum;
    }

    public void setCostSum(int costSum) {
        this.costSum = costSum;
    }

    public int getChargeSum() {
        return chargeSum;
    }

    public void setChargeSum(int chargeSum) {
        this.chargeSum = chargeSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourtReservation that = (CourtReservation) o;

        if (peopleCount != that.peopleCount) return false;
        if (costSum != that.costSum) return false;
        if (chargeSum != that.chargeSum) return false;
        if (!startTime.equals(that.startTime)) return false;
        return endTime.equals(that.endTime);

    }

    @Override
    public int hashCode() {
        int result = startTime.hashCode();
        result = 31 * result + endTime.hashCode();
        result = 31 * result + peopleCount;
        result = 31 * result + costSum;
        result = 31 * result + chargeSum;
        return result;
    }

    public int getStartHour() {
        return startTime.getHourOfDay();
    }

    public int getEndHour() {
        return endTime.getHourOfDay();
    }

    public boolean isWeekend() {
        return startTime.getDayOfWeek() == DateTimeConstants.SATURDAY || startTime.getDayOfWeek() == DateTimeConstants.SUNDAY;
    }

    public int getYear() {
        return startTime.getYear();
    }

    public int getMonth() {
        return startTime.getMonthOfYear();
    }

    public int getDay() {
        return startTime.getDayOfMonth();
    }

    public int getProfit() {
        return chargeSum - costSum;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void getDiscount(List<Discount> discounts) {
        for(Discount discount : discounts) {
            if(discount.isValid(startTime)) {
                costSum *= discount.getRate();
            }
        }
    }
}
