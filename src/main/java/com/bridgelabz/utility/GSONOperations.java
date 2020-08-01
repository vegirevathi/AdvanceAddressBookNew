package com.bridgelabz.utility;

import com.bridgelabz.model.Person;
import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GSONOperations implements IFileOperator {
    @Override
    public void fileWriter(List<Person> addressBook, String filePath) {

    }

    @Override
    public List<Person> fileReader(String filePath) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            CsvToBeanBuilder<Person> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(Person.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<Person> csvToBean = csvToBeanBuilder.build();
            List<Person> personList = csvToBean.parse();
            Gson gson = new Gson();
            String json = gson.toJson(personList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
