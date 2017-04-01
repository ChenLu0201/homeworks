package com.tw.lane.bcc.io;

import com.tw.lane.bcc.common.CourtReservation;
import com.tw.lane.bcc.service.CostCalculator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by luchen on 15/10/2016.
 */
public class OutputFormaterTest {
    @Test
    public void should_format_single_court_reservation_summary() {
        String expected = "[Summary]\n\n" +
                "2016-06-02 20:00~22:00 +210 -240 -30\n\n" +
                "Total Income: 210\n" +
                "Total Payment: -240\n" +
                "Profit: -30";
        List<CourtReservation> reservations = new ArrayList<CourtReservation>();
        CourtReservation courtReservation = new CourtReservation(2016,6,2,20,22,7);
        reservations.add(courtReservation);
        CostCalculator.calculateCostAndChargedFee(courtReservation);
        assertThat(OutputFormater.formatCostSummary(reservations).toString(), is(expected));
    }
}