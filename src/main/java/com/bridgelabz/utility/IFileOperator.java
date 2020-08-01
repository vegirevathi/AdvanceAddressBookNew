package com.bridgelabz.utility;

import com.bridgelabz.model.Person;

import java.util.List;

public interface IFileOperator {
      void fileWriter(List<Person> addressBook, String filePath);
      List<Person> fileReader(String filePath);
}
