package com.kelaniya.uni;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DataRetrieving {


    public void displayData() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/report_generator", "root", "");
            Statement statement = connection.createStatement();

            String start = "2021-05-01";  /*Get the Dates from Command line input here*/
            String end = "2021-12-29";
            // Get the month Number here
            int startmonth = Integer.parseInt(String.valueOf(start.substring(5, 7)));
            int endmonth = Integer.parseInt(String.valueOf(end.substring(5, 7)));

            ArrayList<String[]> allmonths = new ArrayList<String[]>();
            System.out.println("Month\tTotal Revenue\tTotal Sales");

            for (int i = startmonth; i <= endmonth; i++) {
                //Get data for each month
                String montharr[] = new String[3];

                ResultSet resultset = statement.executeQuery("SELECT SUM(price) AS revenue, COUNT(order_id) AS totsales FROM orders " +
                        "WHERE date BETWEEN '" + start + "' AND '" + end + "' " +
                        "AND MONTH(date)='" + i + "'");

                if (resultset.next()) {
                    montharr[0] = Integer.toString(i);
                    montharr[1] = resultset.getString("revenue");
                    montharr[2] = resultset.getString("totsales");
                    allmonths.add(montharr);
                }


            }
            //Print monthly report data
            for (String[] m : allmonths) {
                for (String x : m) {
                    System.out.print(x + "\t\t\t");
                }
                System.out.println("");
            }


        } catch (Exception e) {
            e.printStackTrace();

        }

    }


}
