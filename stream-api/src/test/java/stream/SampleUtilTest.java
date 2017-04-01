package stream;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luchen on 01/04/2017.
 */
public class SampleUtilTest {
    private SampleUtil sampleUtil = new SampleUtil();

    @Test
    public void testFilterList() throws Exception {
        System.out.println(sampleUtil.filterList());
    }

    @Test
    public void testDistinctList() throws Exception {
        System.out.println(sampleUtil.distinct());
    }

    @Test
    public void testLimit() throws Exception {
        System.out.println(sampleUtil.limit());
    }

    @Test
    public void testMap() throws Exception {
        System.out.println(sampleUtil.mapList());
    }
}