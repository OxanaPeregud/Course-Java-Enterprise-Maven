package com.peregud.database_sql_person;

import java.util.List;

public class Starter {

    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepositorySQL();
        List<Person> list = PersonGeneratorService.generate(100);
        PersonListUtil.createPersonList(list).forEach(System.out::println);
        personRepository.personInput(PersonListUtil.createPersonList(list));
        List<Person> readPersonList = PersonListUtil.createPersonList(list);
        PersonView.displayPersonList(readPersonList);
    }
}
