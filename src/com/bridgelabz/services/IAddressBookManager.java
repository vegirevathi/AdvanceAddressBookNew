package com.bridgelabz.services;

import com.bridgelabz.model.Person;

import java.util.ArrayList;
import java.util.HashMap;

public interface IAddressBookManager {
    void displayAddressBook();

    void addPerson();

    void editPerson();

    Person getObjectWithName(String firstName);

    Person getObjectWithPhoneNumber(String phoneNumber);

    void deletePerson();

    void viewPersonByCity();

    void viewPersonByState();

    void addValuesCity(HashMap<String, ArrayList<Person>> cityMap, String key, Person person);

    void displayValuesCity(HashMap<String, ArrayList<Person>> cityMap, String city);

    void addValuesState(HashMap<String, ArrayList<Person>> stateMap, String key, Person person);

    void displayValuesState(HashMap<String, ArrayList<Person>> stateMap, String state);
}
