package com.kelaniya.uni.report;

import java.util.ArrayList;

public interface ReportGeneration {

    public abstract ArrayList<String[]> generate(String startDate, String endDate);

}
