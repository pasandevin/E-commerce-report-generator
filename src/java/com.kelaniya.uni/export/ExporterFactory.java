package com.kelaniya.uni.export;

import com.mashape.unirest.http.exceptions.UnirestException;

public class ExporterFactory {

    public Exporter getInstance(String exportMethod, String reportType, String email) throws UnirestException {

        Exporter exporter = null;

        if (exportMethod.equals("email")) {
            EmailGenerator reportEmailGenerator = new ReportEmailGenerator(reportType, email);
            String[] emailContents = reportEmailGenerator.getEmailData();
            String emailSubject = emailContents[0];
            String emailBody = emailContents[1];

            exporter = new EmailExporter(reportType, email, emailSubject, emailBody);
            exporter.export();


        }

        return exporter;
    }

}
