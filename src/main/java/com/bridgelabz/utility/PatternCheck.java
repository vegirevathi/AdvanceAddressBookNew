package com.bridgelabz.utility;

import java.util.Scanner;

public class PatternCheck {
    private static final String NAME_REGEX = "^[A-Z][a-z]{2,}$";
    private static final String ZIP_CODE_REGEX = "^[0-9]{6}$";
    private static final String PHONE_NUMBER_REGEX = "^[0-9]{2}+[ ]+[0-9]{10}$";
    static Scanner input = new Scanner(System.in);

    public String setName(String name) {
        String firstName = input.nextLine();
        if (firstName.matches(NAME_REGEX))
            return firstName;
        System.out.println("Invalid!!! Enter" +name+ "again");
        return setName(name);
    }

    public String setNumber() {
        String zipCode = input.nextLine();
        if (zipCode.matches(ZIP_CODE_REGEX))
            return zipCode;
        System.out.println("Invalid!!! Enter zip code again");
        return setNumber();
    }

    public String setPhoneNumber() {
        String phoneNumber = input.nextLine();
        if (phoneNumber.matches(PHONE_NUMBER_REGEX))
            return phoneNumber;
        System.out.println("Invalid!!! Enter phone number with country code");
        return setPhoneNumber();
    }
}
