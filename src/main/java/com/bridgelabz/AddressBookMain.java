package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Advanced Address Book");

         Scanner input=new Scanner(System.in);

        public void addPerson()
        {
            System.out.println("enter first name");
            String firstName = input.nextLine();
            System.out.println("enter last name");
            String lastName = input.nextLine();
            System.out.println("enter address");
            String address = input.nextLine();
            System.out.println("enter city");
            String city = input.nextLine();
            System.out.println("enter state");
            String state = input.nextLine();
            System.out.println("enter zip");
            String zip = input.nextLine();
            System.out.println("enter phone number");
            String phoneNumber = input.nextLine();
            Person person1 = new Person(firstName, lastName, address, city, state, zip, phoneNumber);
        }
    }
}