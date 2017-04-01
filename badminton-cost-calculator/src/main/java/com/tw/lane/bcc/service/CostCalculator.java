package com.tw.lane.bcc.service;

import com.tw.lane.bcc.common.CourtReservation;
import com.tw.lane.bcc.common.Discount;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luchen on 15/10/2016.
 */
public class CostCalculator {
    private static int[] workDayCost = {30,30,30,50,50,50,50,50,50,80,80,60,60};
    private static int[] weekendCost = {40,40,40,50,50,50,50,50,50,60,60,60,60};
    private static List<Discount> discounts;
    private static int chargeFee = 30;
    private static int reservationStartHour = 9;

    static {
        discounts = new ArrayList<Discount>();
        discounts.add(new Discount(new DateTime(2016, 6, 1, 0, 0, 0), new DateTime(2016, 6, 3, 0, 0, 0), 0.9f));
        discounts.add(new Discount(new DateTime(2016, 6, 4, 0, 0, 0), new DateTime(2016, 6, 5, 0, 0, 0), 0.6f));
    }

    public static void calculateCostAndChargedFee(List<CourtReservation> courtReservations) {
        for(CourtReservation reservation : courtReservations) {
            calculateCostAndChargedFee(reservation);
        }
    }

    public static void calculateCostAndChargedFee(CourtReservation courtReservation) {
        if(courtReservation.getCourtReserved() != 0) {
            if (courtReservation.isWeekend()) {
                calculateCost(courtReservation, weekendCost);
            } else {
                calculateCost(courtReservation, workDayCost);
            }
            courtReservation.setChargeSum(chargeFee * courtReservation.getPeopleCount());
        }
    }

    private static int calculateCost(CourtReservation courtReservation, int[] weekendCost) {
        int costSum = 0;
        int startHour = courtReservation.getStartHour();
        int endHour = courtReservation.getEndHour();
        for (int hourInDay = startHour; hourInDay < endHour; hourInDay++) {
            reservationStartHour = 9;
            costSum += weekendCost[hourInDay - reservationStartHour];
        }
        costSum *= courtReservation.getCourtReserved();
        courtReservation.setCostSum(costSum);
        courtReservation.getDiscount(discounts);
        return costSum;
    }
}
