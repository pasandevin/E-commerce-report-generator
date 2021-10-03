package com.kelaniya.uni;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileGenerator {

    public void generate(List<String[]> csvData) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter("Report.csv"))) {
            writer.writeAll(csvData);
        }
    }

}