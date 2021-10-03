package com.kelaniya.uni.report;

import java.util.ArrayList;

public abstract class TotalCalculator {

    public static double calculate(ArrayList<String[]> monthlyData, int column) {
        double total = 0.0;

        for (String[] data : monthlyData) {
            if (data[column] == null) {
                data[column] = String.valueOf(0);
            } else if (DoubleNumberValidator.isDouble(data[column])) {
                total += Double.parseDouble(data[column]);
            }
        }

        return total;
    }

}
