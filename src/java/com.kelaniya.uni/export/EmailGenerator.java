package com.kelaniya.uni.email;

public class EmailGenerator {

    String reportType;
    String receiverEmail;
    String emailSubject;
    String emailBody;

    public EmailGenerator(String reportType, String receiverEmail) {

        this.reportType = reportType;
        this.receiverEmail = receiverEmail;

    }

    public String[] getEmailData() {

        this.emailSubject = this.reportType;
        this.emailBody = "Hello " + receiverEmail + ", \nHere is your requested report.\nThank you\nElectron Inc.";

        return new String[] { this.emailSubject, this.emailBody};
    }


}