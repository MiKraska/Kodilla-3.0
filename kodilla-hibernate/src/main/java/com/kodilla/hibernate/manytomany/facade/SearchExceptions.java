package com.kodilla.hibernate.manytomany.facade;

public class SearchExceptions extends Exception {

    public static String ERR_COMPANY_NAME_NOT_FOUND = "There is no company names which match to the phrase";
    public static String ERR_EMPLOYEE_NAME_NOT_FOUND = "There is no employee names which match to the phrase";

    public SearchExceptions(String message) {
        super(message);
    }
}
