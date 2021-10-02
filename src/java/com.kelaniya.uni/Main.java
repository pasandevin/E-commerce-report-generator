package com.kelaniya.uni;

import com.kelaniya.uni.email.EmailSender;
import com.kelaniya.uni.input.CommandLineInputs;
import com.kelaniya.uni.report.MonthlySalesReportGeneration;
import com.kelaniya.uni.report.ReportGeneration;
import com.kelaniya.uni.report.ReportGenerationFactory;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.File;
import java.io.IOException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, UnirestException {

        //validate input arguments
        CommandLineInputs commandLineInputs = new CommandLineInputs(args);
        String[] arguments = commandLineInputs.validate();


        //print validated arguments for testing purposes
//        for(String x: arguments){
//            System.out.println(x);
//        }

        //connect database
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Statement statement = databaseConnection.connect();

        //getting the final report data to array list
        ReportGenerationFactory reportGenerationFactory = new ReportGenerationFactory();
        ReportGeneration reportGeneration = reportGenerationFactory.getInstance(arguments[0]);
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

        //outputs
        EmailSender emailsender = new EmailSender(arguments[0],arguments[4]);
        emailsender.sendMail();
       
    }
}




