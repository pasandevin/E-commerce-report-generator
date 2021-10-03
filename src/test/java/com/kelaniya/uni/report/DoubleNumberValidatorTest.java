package com.kelaniya.uni.report;

import org.junit.Test;

import static org.junit.Assert.*;


public class DoubleNumberValidatorTest {

    @Test
    public void shoud_return_true_for_double_values() {

        boolean result = DoubleNumberValidator.isDouble("7.0");
        assertTrue(result);

    }

    @Test
    public void shoud_return_false_for_character_values() {

        boolean result = DoubleNumberValidator.isDouble("c");
        assertFalse(result);

    }
    @Test
    public void shoud_return_false_for_string_values() {

        boolean result = DoubleNumberValidator.isDouble("hello");
        assertFalse(result);

    }


}