package com.bridgelabz.services;

public interface IAddressBookManager {
    void displayAddressBook();

    void addPerson();

    void editPerson();

    void deletePerson();

    void viewPersonByCity();

    void viewPersonByState();

    void searchPersonByCityOrState();

    void sortByName();

    void sortByCity();

    void sortByZipCode();

    void sortByState();
}
