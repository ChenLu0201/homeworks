package com.tw.lane.bcc.io;

import com.tw.lane.bcc.common.CourtReservation;

import java.util.List;

/**
 * Created by luchen on 15/10/2016.
 */
public class OutputFormater {
    private final static String LINE_FORMAT = "%4d-%02d-%02d %02d:00~%02d:00 +%d -%d %d\n";


    public static String formatCostSummary(List<CourtReservation> courtReservations) {
        StringBuilder stringBuilder = new StringBuilder("[Summary]\n\n");
        int totalCost = 0;
        int totalChargedFee = 0;
        int profit = 0;

        for (CourtReservation reservation : courtReservations) {
            stringBuilder.append(formatReservation(reservation));
            totalCost += reservation.getCostSum();
            totalChargedFee += reservation.getChargeSum();
            profit += reservation.getProfit();
        }

        stringBuilder.append(String.format("\nTotal Income: %s", totalChargedFee));
        stringBuilder.append(String.format("\nTotal Payment: %s", totalCost));
        stringBuilder.append(String.format("\nProfit: %s", profit));

        return stringBuilder.toString();
    }

    private static String formatReservation(CourtReservation reservation) {
        return String.format(LINE_FORMAT,
                reservation.getYear(),
                reservation.getMonth(),
                reservation.getDay(),
                reservation.getStartHour(),
                reservation.getEndHour(),
                reservation.getChargeSum(),
                reservation.getCostSum(),
                reservation.getProfit());
    }
}
