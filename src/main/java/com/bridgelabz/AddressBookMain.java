package com.bridgelabz;

import java.util.*;

public class AddressBookMain {
    static Scanner input = new Scanner(System.in);
    LinkedList<Person> personsList;
    private final HashMap<String,ArrayList<Person>>cityMap;
    private final HashMap<String,ArrayList<Person>>stateMap;

    AddressBookMain()
    {
        cityMap=new HashMap<>();
        stateMap=new HashMap<>();
        personsList=new LinkedList<>();
    }

    public void main(String[] args) throws Exception {
        System.out.println("Welcome to Advanced Address Book");
        boolean quit=false;
        AddressBookMain addressBook=new AddressBookMain();
        do{
            System.out.println("enter 1 for adding person to address book");
            System.out.println("enter 2 for editing person");
            System.out.println("enter 3 for deleting a person");
            System.out.println("enter 4 to display Address book");
            System.out.println("ener 5 to sort address book by name");
            System.out.println("ener 6 to sort address book by city");
            System.out.println("ener 7 to sort address book by state");
            System.out.println("ener 8 to sort address book by zip");
            System.out.println("ener 9 to view person by city");
            System.out.println("ener 10 to view person by state");
            System.out.println("enter 11 to quit");
            int option=input.nextInt();
            input.nextLine();
            switch (option) {
                case 1:
                    addressBook.addPerson();
                    break;
                case 2:
                    addressBook.displayAddressBook();
                    addressBook.editperson();
                    break;
                case 3:
                    addressBook.displayAddressBook();
                    addressBook.deletePerson();
                    break;
                case 4:
                    addressBook.displayAddressBook();
                    break;
                case 5:
                    Collections.sort(addressBook.personsList);
                    break;
                case 6:
                    Collections.sort(addressBook.personsList,new sortByCity());
                    break;
                case 7:
                    Collections.sort(addressBook.personsList,new sortByState());
                    break;
                case 8:
                    Collections.sort(addressBook.personsList,new sortByZip());
                    break;
                case 9:
                    addressBook.viewPersonByCity();
                    break;
                case 10:
                    addressBook.viewPersonByState();
                    break;
                case 11:
                    quit=true;
                    break;
            }
        }while (!quit);
    }

    private void displayAddressBook() {
        for(Person person:personsList) {
            System.out.println(person);
        }
    }

    public void addPerson() {
        System.out.println("enter first name");
        String firstName = input.nextLine();
        System.out.println("enter last name");
        String lastName = input.nextLine();
        System.out.println("enter address");
        String address = input.nextLine();
        System.out.println("enter city");
        String city = input.nextLine();
        System.out.println("enter state");
        String state = input.nextLine();
        System.out.println("enter zip");
        String zip = input.nextLine();
        System.out.println("enter phone number");
        String phoneNumber = input.nextLine();
        Person person1 = new Person(firstName, lastName, address, city, state, zip, phoneNumber);
        personsList.add(person1);
        Person duplicate = getObjectWithName(firstName);
        if (person1.equals(duplicate)) {
            System.out.println("there already exists person  with same name in address book");
            return;
        }
        personsList.add(person1);
    }

    public void editperson() {
        System.out.println("enter first name of person ");
        String firstName = input.nextLine();
        Person personToEdit = getObjectWithName(firstName);
        boolean quit = false;
        do {
            System.out.println("enter 1 for editing address");
            System.out.println("enter 2 for editing city");
            System.out.println("enter 3 for editing state");
            System.out.println("enter 4 for editing zip");
            System.out.println("enter 5 for editing phone number");
            System.out.println("enter 6 to quit");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("enter new address");
                    String address = input.nextLine();
                    personToEdit.setAddress(address);
                    break;
                case 2:
                    System.out.println("enter new city");
                    String city = input.nextLine();
                    personToEdit.setCity(city);
                    break;
                case 3:
                    System.out.println("enter new state");
                    String state = input.nextLine();
                    personToEdit.setState(state);
                    break;
                case 4:
                    System.out.println("enter new zip");
                    String zip = input.nextLine();
                    personToEdit.setZip(zip);
                    break;
                case 5:
                    System.out.println("enter new phone number");
                    String phoneNumber = input.nextLine();
                    personToEdit.setPhoneNumber(phoneNumber);
                    break;
                case 6:
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
        return new Person("", "", "", "", "", "", "");
    }

    public void deletePerson() {
        System.out.println("enter first name of person ");
        String firstName = input.nextLine();
        Person personToDelete = getObjectWithName(firstName);
        personsList.remove(personToDelete);
    }

    class sortByCity implements Comparator<Person> {
        public int compare(Person person1,Person person2)
        {
            return person1.getCity().compareTo(person2.getCity());
        }
    }

    class sortByState implements Comparator<Person> {
        public int compare(Person person1,Person person2)
        {
            return person1.getState().compareTo(person2.getState());
        }
    }

    class sortByZip implements Comparator<Person> {
        public int compare(Person person1,Person person2)
        {
            return person1.getZip().compareTo(person2.getZip());
        }
    }

    public void viewPersonByCity()
    {
        System.out.println("enter city");
        String city=input.nextLine();
        displayValues(cityMap,city);
    }

    public void viewPersonByState()
    {
        System.out.println("enter state");
        String state=input.nextLine();
        displayValues(stateMap,state);
    }

    public void displayValues(HashMap<String,ArrayList<Person>> cityMap,String city)
    {
        Iterator it=cityMap.keySet().iterator();
        ArrayList<Person> tempList=null;
        while (it.hasNext())
        {
            String key=it.next().toString();
            tempList=cityMap.get(city);
            if(city.equals(key))
            {
                for(Person person:tempList)
                {
                    System.out.println(person);
                }
                break;
            }
        }
    }
}