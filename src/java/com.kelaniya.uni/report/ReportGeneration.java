package com.kelaniya.uni.report;

import java.sql.Statement;
import java.util.ArrayList;

public interface ReportGeneration {

    public abstract ArrayList<String[]> generate(Statement statement, String startDate, String endDate);

}
