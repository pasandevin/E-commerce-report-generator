package com.kelaniya.uni;

import java.util.ArrayList;

public class ReportGeneration {
    ArrayList<String[]> monthlyData;

    public ReportGeneration(ArrayList<String[]> monthlyData) {
        this.monthlyData = monthlyData;
    }


    public Double totalRevenueCalculate() {
        Double totalRevenue = 0.0;

        for (String[] data : monthlyData) {

            if(data[1] == null) {
                data[1] = String.valueOf(0);
            }

            totalRevenue += Double.parseDouble(data[1]);
        }

        return totalRevenue;
    }


    public int totalSalesCalculate() {
        int totalSales = 0;

        for (String[] data : monthlyData) {
            totalSales += Integer.parseInt(data[2]);
        }

        return totalSales;
    }


    public ArrayList<String[]> finalizeRows() {

        ArrayList<String[]> finalList = new ArrayList<String[]>();

        //add first row to list
        String firstRow[] = new String[3];

        firstRow[0] = "Month";
        firstRow[1] = "Revenue";
        firstRow[2] = "Sales";

        finalList.add(firstRow);

        //add middle rows to list
        for (String[] row : monthlyData) {
            finalList.add(row);
        }

        //add last row to list
        String lastRow[] = new String[3];

        lastRow[0] = "Total";
        lastRow[1] = String.valueOf(totalRevenueCalculate());
        lastRow[2] = String.valueOf(totalSalesCalculate());

        finalList.add(lastRow);

        return finalList;
    }











}
