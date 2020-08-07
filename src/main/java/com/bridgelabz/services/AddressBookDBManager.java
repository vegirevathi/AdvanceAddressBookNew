package com.bridgelabz.services;

import com.bridgelabz.repository.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class AddressBookDBManager {
    static Scanner input = new Scanner(System.in);
    private PreparedStatement preparedStatement;

    public void addPerson() {
        System.out.println("enter first name of person ");
        String firstName = input.nextLine();
        System.out.println("enter last name of person ");
        String lastName = input.nextLine();
        System.out.println("enter city");
        String city = input.nextLine();
        System.out.println("enter state");
        String state = input.nextLine();
        System.out.println("enter zip code");
        String zipCode = input.nextLine();
        System.out.println("Enter phone number");
        String phoneNumber = input.nextLine();

        String addQuery = "INSERT INTO addressbooknew.person(first_name,last_name,city,state,zip_code,phone_number) VALUES(?,?,?,?,?,?)";
        try (Connection connection = DBConnection.getConnection()) {
            preparedStatement = connection.prepareStatement(addQuery);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, city);
            preparedStatement.setString(4, state);
            preparedStatement.setString(5, zipCode);
            preparedStatement.setString(6, phoneNumber);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editPerson() {
        System.out.println("enter first name of person ");
        String firstName = input.nextLine();
        System.out.println("enter last name of person ");
        String lastName = input.nextLine();
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
                    String newCity = input.nextLine();
                    String editQuery = "UPDATE addressbooknew.person SET city =" +newCity+ "WHERE first_name = " +firstName+ "AND last_name = " +lastName;
                    this.editDatabase(editQuery);
                    break;
                case 2:
                    System.out.println("enter new state");
                    String newState = input.nextLine();
                    editQuery = "UPDATE addressbooknew.person SET state =" + newState + "WHERE first_name = " + firstName + "AND last_name = " + lastName;
                    this.editDatabase(editQuery);
                    break;
                case 3:
                    System.out.println("enter new zip");
                    String newZipCode = input.nextLine();
                    editQuery = "UPDATE addressbooknew.person SET zip_code =" + newZipCode + "WHERE first_name = " + firstName + "AND last_name = " + lastName;
                    this.editDatabase(editQuery);
                    break;
                case 4:
                    System.out.println("enter new phone number");
                    String newPhoneNumber = input.nextLine();
                    editQuery = "UPDATE addressbooknew.person SET phone_number =" + newPhoneNumber + "WHERE first_name = " + firstName + "AND last_name = " + lastName;
                    this.editDatabase(editQuery);
                    break;
                case 5:
                    quit = true;
                    break;
            }
        } while (!quit);
    }

    private void editDatabase(String editQuery) {
        try (Connection connection = DBConnection.getConnection()) {
            preparedStatement = connection.prepareStatement(editQuery);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePerson() {
        System.out.println("enter first name of person ");
        String firstName = input.nextLine();
        System.out.println("enter last name of person ");
        String lastName = input.nextLine();
        String deleteQuery = "DELETE FROM addressbooknew.person WHERE first_name = " +firstName+ "AND last_name = " +lastName;
        try (Connection connection = DBConnection.getConnection()) {
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sortByName() {
        String sortQueryByName = "SELECT * FROM addressbooknew.person ORDER BY first_name ASC";
        this.displayAddressBook(sortQueryByName);
        try (Connection connection = DBConnection.getConnection()) {
            preparedStatement = connection.prepareStatement(sortQueryByName);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sortByCity() {
        String sortQueryByCity = "SELECT * FROM addressbooknew.person ORDER BY city ASC";
        this.displayAddressBook(sortQueryByCity);
        try (Connection connection = DBConnection.getConnection()) {
            preparedStatement = connection.prepareStatement(sortQueryByCity);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sortByState() {
        String sortQueryByState = "SELECT * FROM addressbooknew.person ORDER BY state ASC";
        this.displayAddressBook(sortQueryByState);
        try (Connection connection = DBConnection.getConnection()) {
            preparedStatement = connection.prepareStatement(sortQueryByState);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sortByZipCode() {
        String sortQueryByZipcode = "SELECT * FROM addressbooknew.person ORDER BY zip_code ASC";
        this.displayAddressBook(sortQueryByZipcode);
        try (Connection connection = DBConnection.getConnection()) {
            preparedStatement = connection.prepareStatement(sortQueryByZipcode);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayAddressBook(String query) {
        try (Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);) {
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                int zipCode = resultSet.getInt("zip_code");
                int phone_Number = resultSet.getInt("phone_number");
                System.out.println(firstName+ "," +lastName+ "," +city+ "," +state+ "," +zipCode+ "," +phone_Number);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayAll() {
        String displayQuery = "SELECT * FROM addressbooknew.person";
        this.displayAddressBook(displayQuery);
        try (Connection connection = DBConnection.getConnection()) {
            preparedStatement = connection.prepareStatement(displayQuery);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
