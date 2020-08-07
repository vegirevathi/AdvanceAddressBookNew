package com.bridgelabz.controller;

import com.bridgelabz.services.AddressBookDB;
import com.bridgelabz.services.AddressBookManager;
import com.bridgelabz.utility.CSVOperations;
import com.bridgelabz.utility.GSONOperations;
import com.bridgelabz.utility.JSONOperations;

import java.util.*;

public class AddressBookMain {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");

        AddressBookManager addressBook = new AddressBookManager();
        AddressBookDB addressBookDB = new AddressBookDB();
        CSVOperations csvOperations = new CSVOperations();
        csvOperations.start();
        JSONOperations jsonOperations = new JSONOperations();
        jsonOperations.start();
        GSONOperations gsonOperations = new GSONOperations();
        gsonOperations.start();
        System.out.println("Select Read and Write File Operation/n 1. JSON File /n 2. CSV File /n 3. GSON File /n 4. Database");
        int option = input.nextInt();
        input.nextLine();
        switch (option) {
            case 1:
                addressBook = new AddressBookManager(jsonOperations, "AddressBook.json");
                break;
            case 2:
                addressBook = new AddressBookManager(csvOperations, "AddressBook.csv");
                break;
            case 3:
                addressBook = new AddressBookManager(gsonOperations, "AddressBookLibrary.json");
                break;
            case 4:
                addressBookDB.operations();
            default:
                System.out.println("Wrong Entry");
                break;
        }
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
            System.out.println("enter 9 to view person by city");
            System.out.println("enter 10 to view person by state");
            System.out.println("enter 11 to search person by city or state");
            System.out.println("enter 12 to quit");
            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1:
                    addressBook.addPerson();
                    System.out.println("Contact is added");
                    break;
                case 2:
                    addressBook.displayAddressBook();
                    addressBook.editPerson();
                    System.out.println("Contact is edited");
                    break;
                case 3:
                    addressBook.displayAddressBook();
                    addressBook.deletePerson();
                    System.out.println("Contact is deleted");
                    break;
                case 4:
                    addressBook.displayAddressBook();
                    System.out.println("All contacts are shown");
                    break;
                case 5:
                    addressBook.sortByName();
                    break;
                case 6:
                    addressBook.sortByCity();
                    break;
                case 7:
                    addressBook.sortByState();
                    break;
                case 8:
                    addressBook.sortByZipCode();
                    break;
                case 9:
                    addressBook.viewPersonByCity();
                    break;
                case 10:
                    addressBook.viewPersonByState();
                    break;
                case 11:
                    addressBook.searchPersonByCityOrState();
                    break;
                case 12:
                    quit = true;
                    break;
                default:
                    System.out.println("Select anything before you proceed");
                    break;
            }
        } while (!quit);
    }

}
