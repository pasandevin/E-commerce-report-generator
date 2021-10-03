package com.kelaniya.uni;

import com.kelaniya.uni.export.Exporter;
import com.kelaniya.uni.export.ExporterFactory;
import com.kelaniya.uni.fileGenerator.FileGenerator;
import com.kelaniya.uni.input.Inputs;
import com.kelaniya.uni.report.ReportGeneration;
import com.kelaniya.uni.report.ReportGenerationFactory;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.ArrayList;

public class ReportGeneratorApp {

    private Inputs inputs;
    private ReportGenerationFactory reportGenerationFactory;
    private FileGenerator fileGenerator;
    private ExporterFactory exporterFactory;

    public ReportGeneratorApp(
            Inputs inputs,
            ReportGenerationFactory reportGenerationFactory,
            FileGenerator fileGenerator,
            ExporterFactory exporterFactory
    ) {

        this.inputs = inputs;
        this.reportGenerationFactory = reportGenerationFactory;
        this.fileGenerator = fileGenerator;
        this.exporterFactory = exporterFactory;

    }

    public void execute() throws IOException, UnirestException {

        String[] arguments = inputs.validate();

        String reportType = arguments[0];
        String reportStartDate = arguments[1];
        String reportEndDate = arguments[2];
        String outputMethod = arguments[3];
        String receiverEmail = arguments[4];

        ReportGeneration reportGeneration = reportGenerationFactory.getInstance(reportType);
        ArrayList<String[]> finalReportData = reportGeneration.generate(reportStartDate, reportEndDate);
        fileGenerator.generate(finalReportData);
        Exporter exporter = exporterFactory.getInstance(outputMethod, reportType, receiverEmail);
        exporter.export();

    }
}
