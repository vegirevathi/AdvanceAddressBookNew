package com.bridgelabz.model;

import com.opencsv.bean.CsvBindByName;

public class Person implements Comparable<Person> {
    @CsvBindByName
    public String firstName;
    @CsvBindByName
    public String lastName;
    @CsvBindByName
    public String city;
    @CsvBindByName
    public String state;
    @CsvBindByName
    public String zipCode;
    @CsvBindByName
    public String phoneNumber;

    public Person() {
    }

    public Person(String firstName, String lastName, String city, String state, String zipCode, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
    }

    public int compareTo(Person person) {
        return this.firstName.compareTo(person.firstName);
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCity() {
        return city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String toString() {
        return firstName + ", " + lastName + ", " + city + ", " + state + ", " + zipCode + ", " + phoneNumber;
    }
}
