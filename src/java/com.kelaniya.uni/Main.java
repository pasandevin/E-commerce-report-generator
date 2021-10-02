package com.kelaniya.uni;

import com.kelaniya.uni.input.CommandLineInputs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        //validate input arguments
        CommandLineInputs commandLineInputs = new CommandLineInputs(args);
        String[] arguments = commandLineInputs.validate();


        //print validated arguments for testing purposes
        for(String x: arguments){
            System.out.println(x);
        }


        //getting data from starting date to end date
        DataRetrieving dataRetrieving = new DataRetrieving(arguments[1], arguments[2]);


        ArrayList<String[]> reportData;
        ArrayList<String[]> finalReportData;

        reportData = dataRetrieving.getMonthlySalesReportData();
        ReportGeneration reportGeneration = new ReportGeneration(reportData);
        finalReportData = reportGeneration.finalizeMonthlySalesReportData();

        /*
        if(arguments[0] == "monthly_sales"){

        }
         */


        /*
        //print report for testing purposes
        for (String[] row : finalMonthlySalesReportData) {
            for (String x : row) {
                System.out.printf("%15s", x);
            }
            System.out.println("");
        }
        */

        CreateCsv createCsv = new CreateCsv();
        createCsv.writeToCsvFile(finalReportData, new File("monthlySalesReport.csv"));
       
    }
}




