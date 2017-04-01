package com.tw.lane.bcc.io;

import com.tw.lane.bcc.Exception.InputLoadingException;
import com.tw.lane.bcc.common.CourtReservation;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luchen on 13/10/2016.
 */
public class InputFileLoader {
    private String filePath;

    public InputFileLoader(String filePath) {
        this.filePath = filePath;
    }

    public List<CourtReservation> loadFile() throws InputLoadingException {
        List<CourtReservation> courtReservations = new ArrayList<CourtReservation>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while(StringUtils.isNotBlank(line)) {
                courtReservations.add(new LineParser().parseLine(line));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new InputLoadingException("Get exception when loads io file and path is : " + filePath, e);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return courtReservations;
    }
}
