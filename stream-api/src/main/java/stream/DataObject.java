package stream;

import com.google.gson.Gson;

/**
 * Created by luchen on 01/04/2017.
 */
public class DataObject {
    private String activity;
    private String place;

    public DataObject(String activity, String place) {
        this.activity = activity;
        this.place = place;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
