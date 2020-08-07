package com.bridgelabz.services;

import java.util.Scanner;

public class AddressBookDB {
    static Scanner input = new Scanner(System.in);

    public void operations() {
        AddressBookDBManager addressBookDBManager = new AddressBookDBManager();
        boolean quit = false;
        do {
            System.out.println("enter 1 for adding person to address book");
            System.out.println("enter 2 for editing person");
            System.out.println("enter 3 for deleting a person");
            System.out.println("enter 4 to display Address book contacts");
            System.out.println("enter 5 to sort address book contacts by name");
            System.out.println("enter 6 to sort address book contacts by city");
            System.out.println("enter 7 to sort address book contacts by state");
            System.out.println("enter 8 to sort address book contacts by zip");
            System.out.println("enter 9 to quit");
            int option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1:
                    addressBookDBManager.addPerson();
                    System.out.println("Contact is added");
                    break;
                case 2:
                    addressBookDBManager.displayAll();
                    addressBookDBManager.editPerson();
                    System.out.println("Contact is edited");
                    break;
                case 3:
                    addressBookDBManager.displayAll();
                    addressBookDBManager.deletePerson();
                    System.out.println("Contact is deleted");
                    break;
                case 4:
                    addressBookDBManager.displayAll();
                    System.out.println("All contacts are shown");
                    break;
                case 5:
                    addressBookDBManager.sortByName();
                    break;
                case 6:
                    addressBookDBManager.sortByCity();
                    break;
                case 7:
                    addressBookDBManager.sortByState();
                    break;
                case 8:
                    addressBookDBManager.sortByZipCode();
                    break;
                case 9:
                    quit = true;
                    break;
                default:
                    System.out.println("Select anything before you proceed");
                    break;
            }
        } while (!quit);
    }
}
