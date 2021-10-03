package com.kelaniya.uni;

import com.kelaniya.uni.export.ExporterFactory;
import com.kelaniya.uni.fileGenerator.CsvFileGenerator;
import com.kelaniya.uni.fileGenerator.FileGenerator;
import com.kelaniya.uni.input.CommandLineInputs;
import com.kelaniya.uni.input.Inputs;
import com.kelaniya.uni.report.ReportGenerationFactory;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, UnirestException {
        //creating objects
        Inputs inputs = new CommandLineInputs(args);
        ReportGenerationFactory reportGenerationFactory = new ReportGenerationFactory();
        FileGenerator fileGenerator = new CsvFileGenerator();
        ExporterFactory exporterFactory = new ExporterFactory();

        ReportGeneratorApp reportGeneratorApp = new ReportGeneratorApp(
                inputs,
                reportGenerationFactory,
                fileGenerator,
                exporterFactory);

        //executing the application
        reportGeneratorApp.execute();

    }
}




