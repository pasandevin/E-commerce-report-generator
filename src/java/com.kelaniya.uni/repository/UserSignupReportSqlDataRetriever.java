package com.kelaniya.uni.repository;

import java.sql.ResultSet;
import java.util.ArrayList;

public class UserSignupReportSqlDataRetriever extends SqlRepository implements DataRetriever {

    public ArrayList<String[]> retrieve(String startDate, String endDate) {

        ArrayList<String[]> allSignup = new ArrayList<String[]>();


        try {

            //Get data for each user

            ResultSet resultset = statement.executeQuery(
                    "SELECT users.f_name AS Name, address.city AS City,address.district As District FROM users,address "
                            + "WHERE users.email=address.email AND users.signup_date BETWEEN '" + startDate +
                            "' AND '" + endDate + "' ");

            while (resultset.next()) {
                String[] userArr = new String[3];
                userArr[0] = resultset.getString("Name");
                userArr[1] = resultset.getString("City");
                userArr[2] = resultset.getString("District");
                allSignup.add(userArr);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return allSignup;

    }

}
