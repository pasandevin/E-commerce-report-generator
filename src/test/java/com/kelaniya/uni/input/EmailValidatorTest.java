package com.kelaniya.uni.input;

import org.junit.Test;
import static org.junit.Assert.*;
public class EmailValidatorTest {

    @Test
    public void shoud_return_true_for_correctly_formatted_emails() {

        boolean result = EmailValidator.isEmailValid("hello@gmail.com");
        assertTrue(result);

    }

    @Test
    public void shoud_return_false_for_incorrectly_formatted_emails() {

        boolean result = EmailValidator.isEmailValid("www.hello.com");
        assertFalse(result);

    }

}