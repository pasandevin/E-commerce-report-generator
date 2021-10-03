package com.kelaniya.uni.export;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExporterFactoryTest {

    @Test
    public void should_return_EmailExporter_object_when_argument_is_email() throws UnirestException {

        ExporterFactory exporterFactory = new ExporterFactory();
        Exporter exporter = exporterFactory.getInstance("email","monthly_sales","joe123@gmail.com");
        assertThat(exporter, instanceOf(EmailExporter.class));
    }

}