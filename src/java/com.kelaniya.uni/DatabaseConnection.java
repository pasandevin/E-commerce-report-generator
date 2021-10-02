package com.kelaniya.uni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {

    public Statement connect(){

        Statement statement = null;

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/report_generator", "root", "");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }
}
