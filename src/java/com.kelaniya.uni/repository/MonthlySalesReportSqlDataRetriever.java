package com.kelaniya.uni.repository;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MonthlySalesReportSqlDataRetriever extends SqlRepository implements DataRetriever {

    public ArrayList<String[]> retrieve(String startDate, String endDate) {

        ArrayList<String[]> monthlyData = new ArrayList<String[]>();

        try {
            // Get the month Number here
            int startingDateOfMonth = Integer.parseInt(startDate.substring(5, 7));
            int endingDateOfMonth = Integer.parseInt(endDate.substring(5, 7));

            for (int i = startingDateOfMonth; i <= endingDateOfMonth; i++) {
                //Get data for each month
                String[] monthArr = new String[3];

                ResultSet resultset = statement.executeQuery(
                        "SELECT SUM(price) AS revenue, COUNT(order_id) AS totalSales FROM orders " +
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

        return monthlyData;

    }

}
