package com.kelaniya.uni.input;

public abstract class DateValidator {

    public static boolean isDateValid(String date) {
        String regex = "^[\\d]{4}-[\\d]{2}-[\\d]{2}$"; //2021-11-03
        return date.matches(regex);
    }

}
