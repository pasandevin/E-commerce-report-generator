package com.kelaniya.uni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DataRetrieving {

    private final String startDate;
    private final String endDate;

    public DataRetrieving(String startDate, String endDate){
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ArrayList<String[]> getMonthlySalesReportData() {

        ArrayList<String[]> allmonths = new ArrayList<String[]>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/report_generator", "root", "");
            Statement statement = connection.createStatement();

            // Get the month Number here
            int startingDateOfMonth = Integer.parseInt(String.valueOf(startDate.substring(5, 7)));
            int endingDateOfMonth = Integer.parseInt(String.valueOf(endDate.substring(5, 7)));

            for (int i = startingDateOfMonth; i <= endingDateOfMonth; i++) {
                //Get data for each month
                String montharr[] = new String[3];

                ResultSet resultset = statement.executeQuery("SELECT SUM(price) AS revenue, COUNT(order_id) AS totsales FROM orders " +
                        "WHERE date BETWEEN '" + startDate + "' AND '" + endDate + "' " +
                        "AND MONTH(date)='" + i + "'");

                if (resultset.next()) {
                    montharr[0] = Integer.toString(i);
                    montharr[1] = resultset.getString("revenue");
                    montharr[2] = resultset.getString("totsales");
                    allmonths.add(montharr);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allmonths;
    }
}
