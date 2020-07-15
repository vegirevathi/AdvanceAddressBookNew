package com.bridgelabz.model;

public class Person implements Comparable<Person> {

    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getLastName() {
        return lastName;
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
