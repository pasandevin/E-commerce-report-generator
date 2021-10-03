package com.kelaniya.uni.report;

import com.kelaniya.uni.repository.DataRetriever;
import com.kelaniya.uni.repository.UserSignupReportSqlDataRetriever;

import java.util.ArrayList;

public class UserSignupReportGenerator implements ReportGenerator {

    public ArrayList<String[]> generate(String startDate, String endDate) {

        DataRetriever dataRetriever = new UserSignupReportSqlDataRetriever();
        ArrayList<String[]> middleData = dataRetriever.retrieve(startDate, endDate);

        ArrayList<String[]> allSignup = new ArrayList<String[]>();

        //add first row to list
        String[] firstRow = new String[3];

        firstRow[0] = "Name";
        firstRow[1] = "City";
        firstRow[2] = "District";

        allSignup.add(firstRow);

        //add middle rows to list
        for (String[] row : middleData) {
            allSignup.add(row);
        }

        return allSignup;
    }

}
