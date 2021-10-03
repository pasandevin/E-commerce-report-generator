package com.kelaniya.uni.report;

public class ReportGenerationFactory {

    public ReportGenerator getInstance(String arguments) {

        ReportGenerator reportGeneration = null;

        //generate the report
        if (arguments.equals("monthly_sales")) {
            reportGeneration = new MonthlySalesReportGenerator();
        } else if (arguments.equals("user_signup")) {
            reportGeneration = new UserSignupReportGenerator();
        }

        return reportGeneration;
    }

}
