package com.bridgelabz.utility;

import com.bridgelabz.model.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONOperations implements IFileOperator {
    @Override
    public void fileWriter(List<Person> addressBook, String filePath) {
        JSONArray personList = new JSONArray();
        addressBook.forEach(person -> {
            JSONObject personDetails = new JSONObject();
            personDetails.put("First Name", person.firstName);
            personDetails.put("Last Name", person.lastName);
            personDetails.put("Phone Number", person.phoneNumber);
            personDetails.put("City", person.city);
            personDetails.put("State", person.state);
            personDetails.put("Zipcode", person.zipCode);
            JSONObject personObject = new JSONObject();
            personObject.put("person", personDetails);
            personList.add(personObject);
        });
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.append(personList.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> fileReader(String filePath) {
        JSONParser jsonParser = new JSONParser();
        List<Person> addressBook = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            Object obj = jsonParser.parse(fileReader);
            JSONArray personList = (JSONArray) obj;
            personList.forEach(person -> addressBook.add(parsePersonObject((JSONObject) person)));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return addressBook;
    }

    private Person parsePersonObject(JSONObject jsonObject) {
        JSONObject personObject = (JSONObject) jsonObject.get("person");
        Person person = new Person();
        person.firstName = (String) personObject.get("First Name");
        person.lastName = (String) personObject.get("Last Name");
        person.phoneNumber = (String) personObject.get("Phone Number");
        person.city = (String) personObject.get("City");
        person.state = (String) personObject.get("State");
        person.zipCode = (String) personObject.get("Zipcode");
        return person;
    }
}
