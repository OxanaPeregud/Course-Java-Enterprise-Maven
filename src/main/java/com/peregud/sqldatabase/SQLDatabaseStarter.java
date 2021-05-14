package com.peregud.sqldatabase;

import java.util.List;

public class SQLDatabaseStarter {

    public static void start() {
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
