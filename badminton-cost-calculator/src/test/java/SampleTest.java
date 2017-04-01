import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

/**
 * Created by luchen on 13/10/2016.
 */
public class SampleTest {
    @Test
    public void test() {
//        Pattern linePattern = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2}) (\\d{2}):\\d{2}~(\\d{2}):\\d{2} (\\d+)$");
        Pattern linePattern = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2}) (\\d{2}):\\d{2}~(\\d{2}):\\d{2} (\\d+)$");
        Matcher matcher = linePattern.matcher("2016-01-19 18:00~20:00 7");
        matcher.matches();
        System.out.println(matcher.group(1));
//        System.out.println(linePattern.matcher("2016-01-19 18:00~20:00 7").group(0));


    }
}
