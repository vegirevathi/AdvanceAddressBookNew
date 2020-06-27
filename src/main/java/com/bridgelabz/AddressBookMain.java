package com.bridgelabz;

import java.util.LinkedList;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Advanced Address Book");

        Scanner input = new Scanner(System.in);
        private final LinkedList<Person> personsList;

        public void addPerson ()
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

        public void editperson ()
        {
            System.out.println("enter first name of person ");
            String firstName = input.nextLine();
            Person personToEdit = getObjectWithName(firstName);
            boolean quit = false;
            do {
                System.out.println("enter 1 for editing address");
                System.out.println("enter 2 for editing city");
                System.out.println("enter 3 for editing state");
                System.out.println("enter 4 for editing zip");
                System.out.println("enter 5 for editing phone number");
                System.out.println("enter 6 to quit");
                int choice = input.nextInt();
                input.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("enter new address");
                        String address = input.nextLine();
                        personToEdit.setAddress(address);
                        break;
                    case 2:
                        System.out.println("enter new city");
                        String city = input.nextLine();
                        personToEdit.setCity(city);
                        break;
                    case 3:
                        System.out.println("enter new state");
                        String state = input.nextLine();
                        personToEdit.setState(state);
                        break;
                    case 4:
                        System.out.println("enter new zip");
                        String zip = input.nextLine();
                        personToEdit.setZip(zip);
                        break;
                    case 5:
                        System.out.println("enter new phone number");
                        String phoneNumber = input.nextLine();
                        personToEdit.setPhoneNumber(phoneNumber);
                        break;
                    case 6:
                        quit = true;
                        break;
                }

            } while (!quit);

        }

        public Person getObjectWithName(String firstName)
        {
            for(Person person:personsList)
            {
                if(person.getFirstName().equals(firstName))
                {
                    return person;
                }
            }
            return new Person("","","","","","","");
        }

    }
}