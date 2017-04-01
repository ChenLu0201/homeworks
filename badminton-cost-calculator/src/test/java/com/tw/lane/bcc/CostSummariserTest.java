package com.tw.lane.bcc;

import com.tw.lane.bcc.Exception.InputLoadingException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luchen on 15/10/2016.
 */
public class CostSummariserTest {
    @Test
    public void should_summarise_cost_when_input_is_correct() throws InputLoadingException {
        System.out.println(new CostSummariser().generateSummary("/Users/luchen/IdeaProjects/homeworks/badminton-cost-calculator/src/test/resources/input.txt"));
    }

}