package com.bridgelabz.utility;

import com.bridgelabz.model.Person;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVOperations implements IFileOperator {
    @Override
    public void fileWriter(List<Person> addressBook, String filePath) {
        try (Writer writer = Files.newBufferedWriter(Paths.get(filePath))) {
            StatefulBeanToCsv<Person> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            beanToCsv.write(addressBook);
        } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> fileReader(String filePath) {
        List<Person> personsList = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            csvReader.readNext();
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                personsList.add(new Person(nextRecord[0], nextRecord[1], nextRecord[2],
                        nextRecord[3], nextRecord[4], nextRecord[5]));
            }
        } catch (IOException e ) {
            e.printStackTrace();
        }
        return personsList;
    }
}
