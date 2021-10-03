package com.kelaniya.uni.input;

import org.junit.Test;


import static org.junit.Assert.*;

public class DateValidatorTest {

    @Test
    public void shoud_return_true_for_correctly_formatted_dates() {

        boolean result = DateValidator.isDateValid("2021-03-12");
        assertTrue(result);

    }

    @Test
    public void shoud_return_false_for_incorrectly_formatted_dates() {

        boolean result = DateValidator.isDateValid("12-03-2021");
        assertFalse(result);

    }


}