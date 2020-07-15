package com.bridgelabz.controller;

import com.bridgelabz.model.Person;
import com.bridgelabz.services.AddressBookManager;

import java.util.*;

public class AddressBookMain {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");
        boolean quit = false;
        AddressBookManager addressBook = new AddressBookManager();
        do{
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
            System.out.println("enter 11 to quit");
            int option=input.nextInt();
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
                    Collections.sort(addressBook.personsList);
                    break;
                case 6:
                    Collections.sort(addressBook.personsList, Comparator.comparing(Person::getCity));
                    break;
                case 7:
                    Collections.sort(addressBook.personsList, Comparator.comparing(Person::getState));
                    break;
                case 8:
                    Collections.sort(addressBook.personsList, Comparator.comparing(Person::getZipCode));
                    break;
                case 9:
                    addressBook.viewPersonByCity();
                    break;
                case 10:
                    addressBook.viewPersonByState();
                    break;
                case 11:
                    quit = true;
                    break;
                default:
                    System.out.println("Select anything before you proceed");
                    break;
            }
        }while (!quit);
    }

}
