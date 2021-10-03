package com.kelaniya.uni.report;

public abstract class DoubleNumberValidator {

    public static boolean isDouble(String string) {

        try {
            Double.parseDouble(string);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

}
