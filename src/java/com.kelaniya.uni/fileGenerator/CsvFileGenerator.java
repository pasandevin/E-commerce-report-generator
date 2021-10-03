package com.kelaniya.uni.fileGenerator;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileGenerator implements FileGenerator {

    public void generate(List<String[]> csvData) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter("Report.csv"))) {
            writer.writeAll(csvData);
        }
    }

}