package com.kelaniya.uni.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SqlRepository {

    Statement statement = null;

    public SqlRepository() {

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/report_generator",
                    "root",
                    "");

            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
