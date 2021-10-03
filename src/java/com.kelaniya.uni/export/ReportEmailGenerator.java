package com.kelaniya.uni.export;

public class ReportEmailGenerator implements EmailGenerator{

    String reportType;
    String receiverEmail;
    String emailSubject;
    String emailBody;

    public ReportEmailGenerator(String reportType, String receiverEmail) {

        this.reportType = reportType;
        this.receiverEmail = receiverEmail;

    }

    public String[] getEmailData() {

        this.emailSubject = this.reportType;
        this.emailBody = "Hello " + receiverEmail + ", \nHere is your requested report.\nThank you\nElectron Inc.";

        return new String[]{this.emailSubject, this.emailBody};
    }


}
