package com.kelaniya.uni.email;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.File;

public class SendEmail {

    public static JsonNode sendSimpleMessage() throws UnirestException {

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
                        "jayawardene.pasandevin@gmail.com"
                )
                .queryString(
                        "subject",
                        "java"
                )
                .queryString(
                        "text", "testing"
                )
                .queryString("html", "<h1>Hello world</h1>")
                .field("attachment", new File("/Users/pasandevin/Downloads/Notice for the students 2018.2019 Academic year examinations 30092021 copy.pdf"))
                .asJson();

        return request.getBody();
    }
}