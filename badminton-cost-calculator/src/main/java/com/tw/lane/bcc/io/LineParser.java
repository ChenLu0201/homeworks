package com.tw.lane.bcc.io;

import com.tw.lane.bcc.Exception.InputLoadingException;
import com.tw.lane.bcc.common.CourtReservation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by luchen on 15/10/2016.
 */
public class LineParser {
    private static Pattern linePattern = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2}) (\\d{2}):\\d{2}~(\\d{2}):\\d{2} (\\d+)$");

    public CourtReservation parseLine(String line) throws InputLoadingException {
        Matcher matcher = linePattern.matcher(line);
        if (matcher.matches()) {
            int year = Integer.valueOf(matcher.group(1));
            int month = Integer.valueOf(matcher.group(2));
            int day = Integer.valueOf(matcher.group(3));
            int startHoursOfDay = Integer.valueOf(matcher.group(4));
            int endHoursOfDay = Integer.valueOf(matcher.group(5));
            int peopleCount = Integer.valueOf(matcher.group(6));
            return new CourtReservation(year, month, day, startHoursOfDay, endHoursOfDay, peopleCount);
        } else {
            throw new InputLoadingException("get an illegal line, line is: " + line);
        }
    }
}
