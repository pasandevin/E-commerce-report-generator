package com.kelaniya.uni.email;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


import java.io.File;

public class EmailSender {

    String reportType;
    String receiverEmail;
    String filePath;
    String emailSubject;
    String emailBody;

    public EmailSender(String reportType, String receiverEmail, String emailSubject, String emailBody) {

        this.reportType = reportType;
        this.receiverEmail = receiverEmail;
        this.filePath = "monthlySalesReport.csv";
        this.emailSubject = emailSubject;
        this.emailBody = emailBody;


    }




    public JsonNode sendMail() throws UnirestException {

        HttpResponse<JsonNode> request = Unirest.post(
                "https://api.mailgun.net/v3/" + "sandboxf632d3f500664c9187a03a44da46b023.mailgun.org" + "/messages"
                )
                .basicAuth(
                        "api",
                        "408171ac6e719e1b236de77c3aefbcff-dbdfb8ff-38e35d46"
                )
                .queryString(
                        "from",
                        "Excited User <pasandevin@sandboxf632d3f500664c9187a03a44da46b023.mailgun.org>"
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