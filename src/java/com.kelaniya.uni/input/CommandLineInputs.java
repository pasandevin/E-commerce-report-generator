package com.kelaniya.uni.input;

public class CommandLineInputs implements Inputs {

    private final String[] args;

    public CommandLineInputs(String[] args) {
        this.args = args;
    }

    public String[] validate() {

        if (args.length == 0) {
            System.out.println("Please provide the arguments. ");
        }

        String type = args[0];
        String start_date = args[1];
        String end_date = args[2];
        String output_method = args[3];
        String email_address = args[4];

        String[] validated_input = new String[5];

        //validate the type of report
        if (!(type.equals("monthly_sales") || type.equals("user_signup"))) {
            System.out.println("Please provide type of report as monthly_sales or user_signup");
        } else {
            validated_input[0] = type;
        }

        //validate start date
        if (DateValidator.isDateValid(start_date) == false) {
            System.out.println("Please enter start date in correct format yyyy-mm-dd ");
        } else {
            validated_input[1] = start_date;
        }

        //validate start date
        if (DateValidator.isDateValid(end_date) == false) {
            System.out.println("Please enter end date in correct format yyyy-mm-dd ");
        } else {
            validated_input[2] = end_date;
        }

        // validate the output method
        if (!(output_method.equals("email") || output_method.equals("file"))) {
            System.out.println("please provide out put method 'email' or 'file' ");
        } else {
            validated_input[3] = output_method;
        }

        //validate email
        if (EmailValidator.isEmailValid(email_address) == false) {
            System.out.println("Please enter email in correct format ex:- joe123@gmail ");
        } else {
            validated_input[4] = email_address;
        }

        return args;
    }
}
