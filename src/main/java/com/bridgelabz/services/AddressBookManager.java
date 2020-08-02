package com.bridgelabz.services;

import com.bridgelabz.model.Person;
import com.bridgelabz.utility.IFileOperator;
import com.bridgelabz.utility.PatternCheck;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookManager implements IAddressBookManager {
    static Scanner input = new Scanner(System.in);
    PatternCheck patternCheck = new PatternCheck();

    String filePath;
    IFileOperator fileOperator;
    public List<Person> personsList;

    public AddressBookManager(IFileOperator fileOperator, String filePath) {
        this.fileOperator = fileOperator;
        this.filePath = filePath;
        this.personsList = fileOperator.fileReader(filePath);
    }

    public AddressBookManager() {
    }

    public void displayAddressBook() {
        personsList.forEach(System.out::println);
    }

    public void addPerson() {
        System.out.println("enter first name of person ");
        String firstName = patternCheck.setName("firstName");
        System.out.println("enter last name of person ");
        String lastName = patternCheck.setName("lastName");
        System.out.println("enter city");
        String city = patternCheck.setName("city");
        System.out.println("enter state");
        String state = patternCheck.setName("state");
        System.out.println("enter zip code");
        String zipCode = patternCheck.setNumber();
        System.out.println("Enter phone number");
        String phoneNumber = patternCheck.setPhoneNumber();
        Person person1 = new Person(firstName, lastName, city, state, zipCode, phoneNumber);
        for (Person person : personsList) {
            if (person.getFirstName().equalsIgnoreCase(firstName) && person.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("This contact is already existed with same name and phone number in address book");
                return;
            }
        }
        personsList.add(person1);
        List<Person> collect = personsList.stream().distinct().collect(Collectors.toList());
        fileOperator.fileWriter(collect, filePath);
    }

    public void editPerson() {
        System.out.println("enter first name of person ");
        String firstName = input.nextLine();
        System.out.println("enter last name of person ");
        String lastName = input.nextLine();
        Person personToEdit = personsList.stream().filter(person -> person.firstName.equalsIgnoreCase(firstName)
                && person.getLastName().equalsIgnoreCase(lastName)).findFirst().orElse(null);
        boolean quit = false;
        do {
            System.out.println("enter 1 for editing city");
            System.out.println("enter 2 for editing state");
            System.out.println("enter 3 for editing zip");
            System.out.println("enter 4 for editing phone number");
            System.out.println("enter 5 to quit");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("enter new city");
                    String city = input.nextLine();
                    personToEdit.setCity(city);
                    break;
                case 2:
                    System.out.println("enter new state");
                    String state = input.nextLine();
                    personToEdit.setState(state);
                    break;
                case 3:
                    System.out.println("enter new zip");
                    String zip = input.nextLine();
                    personToEdit.setZipCode(zip);
                    break;
                case 4:
                    System.out.println("enter new phone number");
                    String phoneNumber = input.nextLine();
                    personToEdit.setPhoneNumber(phoneNumber);
                    break;
                case 5:
                    quit = true;
                    break;
            }
        } while (!quit);
        fileOperator.fileWriter(personsList, filePath);
    }

    public void deletePerson() {
        System.out.println("enter first name of person ");
        String firstName = input.nextLine();
        System.out.println("enter last name of person ");
        String lastName = input.nextLine();
        Person personToDelete = personsList.stream().filter(person -> person.firstName.equalsIgnoreCase(firstName)
                && person.lastName.equalsIgnoreCase(lastName)).findFirst().orElse(null);
        personsList.remove(personToDelete);
        fileOperator.fileWriter(personsList, filePath);
    }

    public void viewPersonByCity() {
        List<Person> personsList = fileOperator.fileReader(filePath);
        System.out.println("enter city");
        String city = input.nextLine();
        Person viewPersonByCity = personsList.stream().filter(person -> person.city.equalsIgnoreCase(city))
                .findFirst().orElse(null);
        System.out.println(viewPersonByCity);
    }

    public void viewPersonByState() {
        List<Person> personsList = fileOperator.fileReader(filePath);
        System.out.println("enter state");
        String state = input.nextLine();
        Person viewPersonByState = personsList.stream().filter(person -> person.state.equalsIgnoreCase(state))
                .findFirst().orElse(null);
        System.out.println(viewPersonByState);
    }

    public void searchPersonByCityOrState() {
        List<Person> personsList = fileOperator.fileReader(filePath);
        System.out.println("enter city or state");
        String cityOrState = input.nextLine();
        Person searchPersonByCityOrState = personsList.stream().filter(person -> person.city.equalsIgnoreCase(cityOrState)
                || person.state.equalsIgnoreCase(cityOrState)).findFirst().orElse(null);
        System.out.println(searchPersonByCityOrState);
    }

    public void sortByName() {
        personsList.sort(Comparator.comparing(Person::getFirstName));
    }

    public void sortByCity() {
        personsList.sort(Comparator.comparing(Person::getCity));
    }

    public void sortByState() {
        personsList.sort(Comparator.comparing(Person::getState));
    }

    public void sortByZipCode() {
        personsList.sort(Comparator.comparing(Person::getZipCode));
    }
}