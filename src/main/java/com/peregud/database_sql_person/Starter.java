package com.peregud.database_sql_person;

import java.util.List;

public class Starter {

    public static void main(String[] args) {
        CreateDatabaseService.createDatabase();
        PersonRepository personRepository = new PersonRepositorySQL();
        List<Person> list = PersonGeneratorService.generate(100);
        List<Person> filteredPersonList = PersonListUtil.createPersonList(list);
        PersonView.displayPersonFullList(filteredPersonList);
        personRepository.personInput(filteredPersonList);
        List<Person> personList = personRepository.personOutput();
        PersonView.displayPersonFirstAndLastName(personList);
    }
}
