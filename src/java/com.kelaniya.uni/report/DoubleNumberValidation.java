package com.kelaniya.uni.report;

public abstract class DoubleNumberValidation {

    public static boolean isDouble(String string){
        try{
            Double.parseDouble(string);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }

}
