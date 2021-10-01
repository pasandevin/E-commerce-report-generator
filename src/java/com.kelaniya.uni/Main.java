package com.kelaniya.uni;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DataRetrieving dataRetrieving = new DataRetrieving();
        ArrayList<String[]> monthlyReport = dataRetrieving.displayData();

        ReportGeneration reportGeneration = new ReportGeneration(monthlyReport);
        ArrayList<String[]> finalList = reportGeneration.finalizeRows();

        //print arrayList for testing purposes
        for (String[] row : finalList) {
                for (String x : row) {
                    System.out.printf("%15s", x);
                }
                System.out.println("");
        }
        
    }
}
