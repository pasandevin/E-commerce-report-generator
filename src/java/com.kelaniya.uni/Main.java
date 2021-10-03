package com.kelaniya.uni;

import com.kelaniya.uni.email.EmailSender;
import com.kelaniya.uni.email.EmailGenerator;
import com.kelaniya.uni.input.CommandLineInputs;
import com.kelaniya.uni.report.ReportGeneration;
import com.kelaniya.uni.report.ReportGenerationFactory;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException, UnirestException {

        //validate input arguments
        CommandLineInputs commandLineInputs = new CommandLineInputs(args);
        String[] arguments = commandLineInputs.validate();

        String reportType = arguments[0];
        String reportStartDate = arguments[1];
        String reportEndDate = arguments[2];
        String outputMethod = arguments[3];
        String receiverEmail = arguments[4];


        //print validated arguments for testing purposes
//        for(String x: arguments){
//            System.out.println(x);
//        }

        //connect database
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Statement statement = databaseConnection.connect();

        //getting the final report data to array list
        ReportGenerationFactory reportGenerationFactory = new ReportGenerationFactory();
        ReportGeneration reportGeneration = reportGenerationFactory.getInstance(reportType);
        ArrayList<String[]> finalReportData = reportGeneration.generate(statement, reportStartDate, reportEndDate);

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
        CsvFileGenerator csvFileGenerator = new CsvFileGenerator();
        csvFileGenerator.generate(finalReportData);

        //outputs

        if (Objects.equals(outputMethod, "email")) {
            EmailGenerator emailGenerator = new EmailGenerator(reportType,receiverEmail);
            String [] emailContents = emailGenerator.getEmailData();
            String emailSubject = emailContents[0];
            String emailBody = emailContents[1];

            EmailSender emailsender = new EmailSender(reportType,receiverEmail, emailSubject, emailBody);
            emailsender.sendMail();

        }

       
    }
}




