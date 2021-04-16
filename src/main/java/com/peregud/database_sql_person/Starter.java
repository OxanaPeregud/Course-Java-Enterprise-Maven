package com.peregud.database_sql_person;

import java.util.List;

public class Starter {

    public static void main(String[] args) {
        CreateDatabaseService.createDatabase();
        PersonRepository personRepository = new PersonRepositorySQL();
        List<Person> list = PersonGeneratorService.generate(100);
        PersonView.displayPersonFullList(PersonListUtil.createPersonList(list));
        personRepository.personInput(PersonListUtil.createPersonList(list));
        List<Person> personList = personRepository.personOutput();
        PersonView.displayPersonFirstAndLastName(personList);
    }
}
