package com.tw.lane.bcc.service;

import com.tw.lane.bcc.common.CourtReservation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by luchen on 15/10/2016.
 */
public class CostCalculatorTest {
    @Test
    public void should_calculate_cost_on_weekday_when_courts_reserved() {
        CourtReservation courtReservation = new CourtReservation(2016,6,2,20,22,7);
        CostCalculator.calculateCostAndChargedFee(courtReservation);
        assertThat(courtReservation.getCostSum(), is(240));
        assertThat(courtReservation.getChargeSum(), is(-210));
    }

    @Test
    public void should_calculate_cost_on_weekday_when_no_court_reserved() {
        CourtReservation courtReservation = new CourtReservation(2016,6,2,20,22,3);
        CostCalculator.calculateCostAndChargedFee(courtReservation);
        assertThat(courtReservation.getCostSum(), is(0));
        assertThat(courtReservation.getChargeSum(), is(0));
    }

    @Test
    public void test_empty_list() throws Exception {
        List<String> strList = new ArrayList<String>();
        for(String str : strList) {
            System.out.println("this is an empty string list");
        }

    }
}