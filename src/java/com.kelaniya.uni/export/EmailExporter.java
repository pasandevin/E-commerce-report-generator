package com.kelaniya.uni.export;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.File;

public class EmailExporter implements Exporter {

    String reportType;
    String receiverEmail;
    String filePath;
    String emailSubject;
    String emailBody;

    public EmailExporter(String reportType, String receiverEmail, String emailSubject, String emailBody) {

        this.reportType = reportType;
        this.receiverEmail = receiverEmail;
        this.filePath = "Report.csv";
        this.emailSubject = emailSubject;
        this.emailBody = emailBody;

    }

    public JsonNode export() throws UnirestException {

        HttpResponse<JsonNode> request = Unirest.post(
                        "https://api.mailgun.net/v3/" + "sandboxfebcf87b6680495995110a0f85da82a2.mailgun.org" + "/messages"
                )
                .basicAuth(
                        "api",
                        "022831441538e27d28f5103b1aee0a82-dbdfb8ff-8b748728"
                )
                .queryString(
                        "from",
                        "Electron <electron@shop.com>"
                )
                .queryString(
                        "to",
                        this.receiverEmail
                )
                .queryString(
                        "subject",
                        this.emailSubject
                )
                .queryString(
                        "text", this.emailBody
                )

                .field("attachment", new File(this.filePath))
                .asJson();

        return request.getBody();
    }
}
