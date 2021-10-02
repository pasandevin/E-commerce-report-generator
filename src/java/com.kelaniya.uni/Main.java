package com.kelaniya.uni;

import com.kelaniya.uni.input.CommandLineInputs;
import com.kelaniya.uni.report.MonthlySalesReportGeneration;
import com.kelaniya.uni.report.ReportGeneration;

import java.io.File;
import java.io.IOException;
import java.sql.Statement;
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

        //connect database
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Statement statement = databaseConnection.connect();


        //create generic report
        ReportGeneration reportGeneration = null;

        //generate the report
        if(arguments[0].equals("monthly_sales")){
            reportGeneration = new MonthlySalesReportGeneration();
        } else if(arguments[0].equals("user_signup")) {
            //not yet implemented
        }

        //getting the final report data to array list
        ArrayList<String[]> finalReportData = reportGeneration.generate(statement, arguments[1], arguments[2]);

        /*
        //print report for testing purposes
        for (String[] row : finalMonthlySalesReportData) {
            for (String x : row) {
                System.out.printf("%15s", x);
            }
            System.out.println("");
        }
        */

        //generate csv file
        CreateCsv createCsv = new CreateCsv();
        createCsv.writeToCsvFile(finalReportData, new File("monthlySalesReport.csv"));
       
    }
}




