package com.tw.lane.bcc;

import com.tw.lane.bcc.Exception.InputLoadingException;
import com.tw.lane.bcc.common.CourtReservation;
import com.tw.lane.bcc.io.InputFileLoader;
import com.tw.lane.bcc.io.OutputFormater;
import com.tw.lane.bcc.service.CostCalculator;

import java.util.List;

/**
 * Created by luchen on 15/10/2016.
 */
public class CostSummariser {

    public String generateSummary(String inputFile) throws InputLoadingException {
        List<CourtReservation> reservations = new InputFileLoader(inputFile).loadFile();
        CostCalculator.calculateCostAndChargedFee(reservations);
        return OutputFormater.formatCostSummary(reservations);
    }

}
