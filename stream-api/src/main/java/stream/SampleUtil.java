package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by luchen on 01/04/2017.
 */
public class SampleUtil {
    private List<String> sampleList = new ArrayList<>();

    {
        sampleList.add("A");
        sampleList.add("A");
        sampleList.add("B");
        sampleList.add("C");
        sampleList.add("D");
        sampleList.add("E");
        sampleList.add("F");
    }

    public List<String> filterList(){
        return sampleList.stream().filter(s -> s.charAt(0) < 'E').collect(Collectors.toList());
    }

    public List<String> distinct() {
        return sampleList.stream().distinct().collect(Collectors.toList());
    }

    public List<String> limit() {
        return sampleList.stream().limit(2).collect(Collectors.toList());
    }

    public List<DataObject> mapList() {
        return sampleList.stream().map(s -> new DataObject(s, "Wuhan")).collect(Collectors.toList());
    }
}
