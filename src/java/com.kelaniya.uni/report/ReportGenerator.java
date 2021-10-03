package com.kelaniya.uni.report;

import java.util.ArrayList;

public interface ReportGenerator {

    ArrayList<String[]> generate(String startDate, String endDate);

}
