package com.kelaniya.uni.report;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MonthlySalesReportGeneration implements ReportGeneration{

    public ArrayList<String[]> generate(Statement statement, String startDate, String endDate) {

        ArrayList<String[]> monthlyData = new ArrayList<String[]>();

        //add first row to list
        String firstRow[] = new String[3];

        firstRow[0] = "Month";
        firstRow[1] = "Revenue";
        firstRow[2] = "Sales";

        monthlyData.add(firstRow);

        try {
            // Get the month Number here
            int startingDateOfMonth = Integer.parseInt(String.valueOf(startDate.substring(5, 7)));
            int endingDateOfMonth = Integer.parseInt(String.valueOf(endDate.substring(5, 7)));

            for (int i = startingDateOfMonth; i <= endingDateOfMonth; i++) {
                //Get data for each month
                String monthArr[] = new String[3];

                ResultSet resultset = statement.executeQuery("SELECT SUM(price) AS revenue, COUNT(order_id) AS totalSales FROM orders " +
                        "WHERE date BETWEEN '" + startDate + "' AND '" + endDate + "' " +
                        "AND MONTH(date)='" + i + "'");

                if (resultset.next()) {
                    monthArr[0] = Integer.toString(i);
                    monthArr[1] = resultset.getString("revenue");
                    monthArr[2] = resultset.getString("totalSales");
                    monthlyData.add(monthArr);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        //add last row to list
        String lastRow[] = new String[3];

        lastRow[0] = "Total";
        lastRow[1] = String.valueOf(TotalCalculation.calculate(monthlyData,1));
        lastRow[2] = String.valueOf((int)TotalCalculation.calculate(monthlyData,2));

        monthlyData.add(lastRow);

        return monthlyData;
    }

}
