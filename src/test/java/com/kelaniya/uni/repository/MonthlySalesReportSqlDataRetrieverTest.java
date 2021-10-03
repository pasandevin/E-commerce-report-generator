package com.kelaniya.uni.repository;

import org.junit.Test;

import java.util.ArrayList;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class MonthlySalesReportSqlDataRetrieverTest {

    @Test
    public void should_retrieve_one_month_report() {

        MonthlySalesReportSqlDataRetriever monthlySalesReportSqlDataRetriever =
                new MonthlySalesReportSqlDataRetriever();

        ArrayList<String[]> result = monthlySalesReportSqlDataRetriever.retrieve("2021-08-01", "2021-08-31");

        ArrayList<String[]>  test_arr = new ArrayList<>();


        String[] first_row = new String[]{"8", "0", "0"};

        test_arr.add(first_row);

        for (int i = 0; i < 1; i++) {
            for (int y = 0; y < 1; y++) {
                assertThat(result.get(i)[y], is(first_row[y]));
            }


        }


    }

    @Test
    public void should_retrieve_multiple_month_report() {

        MonthlySalesReportSqlDataRetriever monthlySalesReportSqlDataRetriever =
                new MonthlySalesReportSqlDataRetriever();

        ArrayList<String[]> result = monthlySalesReportSqlDataRetriever.retrieve("2021-09-01", "2021-10-31");

        ArrayList<String[]> test_arr = new ArrayList<>();


        test_arr.add(new String[]{"9", "393737", "11"});
        test_arr.add(new String[]{"10", "617466", "9"});


        for (int i = 0; i < 1; i++) {
            for (int y = 0; y < 1; y++) {
                assertThat(result.get(i)[y], is(test_arr.get(i)[y]));
            }


        }

    }


}
