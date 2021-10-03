package com.kelaniya.uni.report;

import com.kelaniya.uni.repository.DataRetriever;
import com.kelaniya.uni.repository.MonthlySalesReportSqlDataRetriever;

import java.util.ArrayList;

public class MonthlySalesReportGenerator implements ReportGenerator {

    public ArrayList<String[]> generate(String startDate, String endDate) {

        DataRetriever dataRetriever = new MonthlySalesReportSqlDataRetriever();
        ArrayList<String[]> middleData = dataRetriever.retrieve(startDate, endDate);
        ArrayList<String[]> monthlyData = new ArrayList<String[]>();

        //add first row to list
        String[] firstRow = new String[3];

        firstRow[0] = "Month";
        firstRow[1] = "Revenue";
        firstRow[2] = "Sales";

        monthlyData.add(firstRow);

        //add middle rows to list
        for (String[] row : middleData) {
            monthlyData.add(row);
        }


        //add last row to list
        String[] lastRow = new String[3];

        lastRow[0] = "Total";
        lastRow[1] = String.valueOf(TotalCalculator.calculate(monthlyData, 1));
        lastRow[2] = String.valueOf((int) TotalCalculator.calculate(monthlyData, 2));

        monthlyData.add(lastRow);

        return monthlyData;
    }

}
