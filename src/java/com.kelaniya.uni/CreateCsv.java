package com.kelaniya.uni;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateCsv {

    private static final String COMMA = ",";
    private static final String DEFAULT_SEPARATOR = COMMA;
    private static final String DOUBLE_QUOTES = "\"";
    private static final String EMBEDDED_DOUBLE_QUOTES = "\"\"";
    private static final String NEW_LINE_UNIX = "\n";
    private static final String NEW_LINE_WINDOWS = "\r\n";




    public static void main(String[] args) throws IOException {




        CreateCsv writer = new CreateCsv();
        writer.writeToCsvFile(createCsvDataSpecial(), new File("C:\\Users\\DELL\\Desktop\\e-commerce-report-generator\\details.csv"));
         System.out.println("Csv File Created");
    }

    public String convertToCsvFormat(final String[] line) {


        return convertToCsvFormat(line, DEFAULT_SEPARATOR);
    }

    public String convertToCsvFormat(final String[] line, final String separator) {
        return convertToCsvFormat(line, separator, true);
    }

    // if quote = true, all fields are enclosed in double quotes
    public String convertToCsvFormat(
            final String[] line,
            final String separator,
            final boolean quote) {

        return Stream.of(line)                              // convert String[] to stream
                .map(l -> formatCsvField(l, quote))         // format CSV field
                .collect(Collectors.joining(separator));    // join with a separator

    }

    // put your extra login here
    private String formatCsvField(final String field, final boolean quote) {

        String result = field;

        if (result.contains(COMMA)
                || result.contains(DOUBLE_QUOTES)
                || result.contains(NEW_LINE_UNIX)
                || result.contains(NEW_LINE_WINDOWS)) {

            // if field contains double quotes, replace it with two double quotes \"\"
            result = result.replace(DOUBLE_QUOTES, EMBEDDED_DOUBLE_QUOTES);

            // must wrap by or enclosed with double quotes
            result = DOUBLE_QUOTES + result + DOUBLE_QUOTES;

        } else {
            // should all fields enclosed in double quotes
            if (quote) {
                result = DOUBLE_QUOTES + result + DOUBLE_QUOTES;
            }
        }

        return result;

    }

    // a standard FileWriter, CSV is a normal text file
    private void writeToCsvFile(List<String[]> list, File file) throws IOException {

        List<String> collect = list.stream()
                .map(this::convertToCsvFormat)
                .collect(Collectors.toList());

        // CSV is a normal text file, need a writer
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String line : collect) {
                bw.write(line);
                bw.newLine();
            }
        }

    }

    private static List<String[]> createCsvDataSpecial() {

        String[] header = {"Make", "Model", "Description", "Price"};

        String record[][]={{"Samsung", "", "49\" Dual QHD, QLED, HDR1000", "6199.00"},
                           {"Dell", "P3421W", "Dell 34, Curved, USB-C Monitor", "2499.00"},
                           {"Dell", "", "Alienware 38 Curved \"Gaming Monitor\"", "6699.00"},
                           {"Samsung", "", "Promotion! Special Price\n49\" Dual QHD, QLED, HDR1000", "4999.00"}
                           };

        List<String[]> list = new ArrayList<>();
        list.add(header);

        for(String[] x:record){
            list.add(x);

        }

        return list;

    }

}