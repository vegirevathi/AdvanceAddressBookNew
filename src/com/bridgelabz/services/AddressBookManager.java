package com.bridgelabz.services;

import com.bridgelabz.model.Person;
import java.util.*;

public class AddressBookManager implements IAddressBookManager {
    static Scanner input = new Scanner(System.in);
    public List<Person> personsList = new ArrayList<>();
    private final HashMap<String,ArrayList<Person>>cityMap = new HashMap<>();
    private final HashMap<String,ArrayList<Person>>stateMap = new HashMap<>();

    public void displayAddressBook() {
        personsList.forEach(x -> {
            System.out.println(x);
        });
    }

    public void addPerson() {
        System.out.println("enter first name");
        String firstName = input.nextLine();
        System.out.println("enter last name");
        String lastName = input.nextLine();
        System.out.println("enter city");
        String city = input.nextLine();
        System.out.println("enter state");
        String state = input.nextLine();
        System.out.println("enter zip");
        String zip = input.nextLine();
        System.out.println("enter phone number");
        String phoneNumber = input.nextLine();
        Person person1 = new Person(firstName, lastName, city, state, zip, phoneNumber);
        Person duplicateName = getObjectWithName(firstName);
        Person duplicateNumber = getObjectWithPhoneNumber(phoneNumber);
        if (person1.equals(duplicateName) && person1.equals(duplicateNumber)) {
            System.out.println("This contact is already existed with same name and phone number in address book");
            return;
        }
        personsList.add(person1);
        addValuesCity(cityMap,city,person1);
        addValuesState(stateMap,state,person1);
    }

    public void editPerson() {
        System.out.println("enter first name of person ");
        String firstName = input.nextLine();
        Person personToEdit = getObjectWithName(firstName);
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

    }

    public Person getObjectWithName(String firstName) {
        for (Person person : personsList) {
            if (person.getFirstName().equals(firstName)) {
                return person;
            }
        }
        return new Person("", "", "", "", "", "");
    }

    public Person getObjectWithPhoneNumber(String phoneNumber) {
        for (Person person : personsList) {
            if (person.getPhoneNumber().equals(phoneNumber)) {
                return person;
            }
        }
        return new Person("", "", "", "", "", "");
    }

    public void deletePerson() {
        System.out.println("enter first name of person ");
        String firstName = input.nextLine();
        Person personToDelete = getObjectWithName(firstName);
        personsList.remove(personToDelete);
    }

    public void viewPersonByCity()
    {
        System.out.println("enter city");
        String city = input.nextLine();
        displayValuesCity(cityMap,city);
    }

    public void viewPersonByState()
    {
        System.out.println("enter state");
        String state = input.nextLine();
        displayValuesState(stateMap,state);
    }

    public void addValuesCity(HashMap<String,ArrayList<Person>> cityMap,String key,Person person)
    {
        ArrayList<Person> tempList;
        if(cityMap.containsKey(key))
        {
            tempList = cityMap.get(key);
            tempList.add(person);
        }
        else
        {
            tempList = new ArrayList<>();
            tempList.add(person);
        }
        cityMap.put(key,tempList);
    }

    public void displayValuesCity(HashMap<String,ArrayList<Person>> cityMap,String city)
    {
        Iterator iterator = cityMap.keySet().iterator();
        ArrayList<Person> tempList;
        while (iterator.hasNext())
        {
            String key = iterator.next().toString();
            tempList = cityMap.get(city);
            if(city.equals(key))
            {
                tempList.forEach(x -> {
                    System.out.println(x);
                });
                break;
            }
        }
    }

    public void addValuesState(HashMap<String,ArrayList<Person>> stateMap,String key,Person person)
    {
        ArrayList<Person> tempList;
        if(stateMap.containsKey(key))
        {
            tempList = stateMap.get(key);
            tempList.add(person);
        }
        else
        {
            tempList = new ArrayList<>();
            tempList.add(person);
        }
        stateMap.put(key,tempList);
    }

    public void displayValuesState(HashMap<String,ArrayList<Person>> stateMap,String state)
    {
        Iterator iterator = stateMap.keySet().iterator();
        ArrayList<Person> tempList;
        while (iterator.hasNext())
        {
            String key = iterator.next().toString();
            tempList = stateMap.get(state);
            if(state.equals(key))
            {
                tempList.forEach(x -> {
                    System.out.println(x);
                });
                break;
            }
        }
    }
}