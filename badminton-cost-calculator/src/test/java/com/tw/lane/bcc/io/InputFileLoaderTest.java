package com.tw.lane.bcc.io;

import com.tw.lane.bcc.Exception.InputLoadingException;
import com.tw.lane.bcc.common.CourtReservation;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by luchen on 13/10/2016.
 */
public class InputFileLoaderTest {

    @Test
    public void should_load_legal_input_file() throws InputLoadingException {
        InputFileLoader inputFileLoader = new InputFileLoader("/Users/luchen/IdeaProjects/homeworks/badminton-cost-calculator/src/test/resources/input.txt");
        List<CourtReservation> courtReservations = inputFileLoader.loadFile();
        assertThat(courtReservations.size(), is(10));
        assertThat(courtReservations.get(0), is(new CourtReservation(2016,6,2,20,22,7)));
    }
}