package com.bridgelabz;

public class Person implements Comparable<Person> {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;

    Person(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
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

    public String getAddress() {
        return address;
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

    public String getZip() {
        return zip;
    }

    public String toString() {
        return firstName + ", " + lastName + ", " + address + ", " + city + ", " + state + ", " + zip + ", " + phoneNumber;
    }

    public boolean equals(Person obj) {
        return this.firstName.equals(obj.firstName);
    }

}
