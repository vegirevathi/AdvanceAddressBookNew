package com.bridgelabz.utility;

import com.bridgelabz.model.Person;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GSONOperations implements IFileOperator {
    @Override
    public void fileWriter(List<Person> addressBook, String filePath) {
        String personDetails = new Gson().toJson(addressBook);
        try (FileWriter fileWriter = new FileWriter(filePath)){
            fileWriter.write(personDetails);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> fileReader(String filePath) {
        List<Person> addressBook = new ArrayList<>();
        try {
            Person[] personDetails = new Gson().fromJson(new FileReader(filePath), Person[].class);
            addressBook = new ArrayList<>(Arrays.asList(personDetails));
        } catch (FileNotFoundException | NullPointerException e) {
            e.printStackTrace();
        }
        return addressBook;
    }
}
