package com.kelaniya.uni.report;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReportGenerationFactoryTest {

    @Test
    public void should_return_MonthlySalesReportGenerator_object_when_argument_is_monthly_sales(){

        ReportGenerationFactory reportGenerationFactory = new ReportGenerationFactory();
        ReportGenerator reportGenerator = reportGenerationFactory.getInstance("monthly_sales");
        assertThat(reportGenerator, instanceOf(MonthlySalesReportGenerator.class));
    }

    @Test
    public void should_return_UserSignupReportGenerator_object_when_argument_is_user_signup(){

        ReportGenerationFactory reportGenerationFactory = new ReportGenerationFactory();
        ReportGenerator reportGenerator = reportGenerationFactory.getInstance("user_signup");
        assertThat(reportGenerator, instanceOf(UserSignupReportGenerator.class));
    }

}