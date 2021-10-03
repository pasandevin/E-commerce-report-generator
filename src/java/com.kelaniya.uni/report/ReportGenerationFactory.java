package com.kelaniya.uni.report;

public class ReportGenerationFactory {

    public ReportGeneration getInstance(String arguments){

        ReportGeneration reportGeneration = null;

        //generate the report
        if(arguments.equals("monthly_sales")){
            reportGeneration = new MonthlySalesReportGeneration();
        } else if(arguments.equals("user_signup")) {
            reportGeneration = new UserSignupReportGeneration();
        }

        return reportGeneration;
    }

}
