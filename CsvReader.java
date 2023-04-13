package caseStudy_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public List<String[]> readCsvData(String filePath) {
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";
        List<String[]> csvData = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                csvData.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return csvData;
    }

}
