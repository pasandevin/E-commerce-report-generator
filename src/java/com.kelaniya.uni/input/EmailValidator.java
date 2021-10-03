package com.kelaniya.uni.input;

public abstract class EmailValidator {

    public static boolean isEmailValid(String email) {
        String regex = "^.+@.+$"; //joe123@gmail.com
        return email.matches(regex);
    }

}
