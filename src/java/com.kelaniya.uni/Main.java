package com.kelaniya.uni;

import com.kelaniya.uni.fileGenerator.CsvFileGenerator;
import com.kelaniya.uni.export.Exporter;
import com.kelaniya.uni.export.ExporterFactory;
import com.kelaniya.uni.fileGenerator.FileGenerator;
import com.kelaniya.uni.input.CommandLineInputs;
import com.kelaniya.uni.input.Inputs;
import com.kelaniya.uni.report.ReportGeneration;
import com.kelaniya.uni.report.ReportGenerationFactory;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, UnirestException {

        //validate input arguments
        Inputs inputs = new CommandLineInputs(args);
        String[] arguments = inputs.validate();

        String reportType = arguments[0];
        String reportStartDate = arguments[1];
        String reportEndDate = arguments[2];
        String outputMethod = arguments[3];
        String receiverEmail = arguments[4];

        //getting the final report data to array list
        ReportGenerationFactory reportGenerationFactory = new ReportGenerationFactory();
        ReportGeneration reportGeneration = reportGenerationFactory.getInstance(reportType);
        ArrayList<String[]> finalReportData = reportGeneration.generate(reportStartDate, reportEndDate);

        //generate file
        FileGenerator fileGenerator = new CsvFileGenerator();
        fileGenerator.generate(finalReportData);

        //export generated file
        ExporterFactory exporterFactory = new ExporterFactory();
        Exporter exporter = exporterFactory.getInstance(outputMethod, reportType, receiverEmail);
        exporter.export();

       
    }
}




