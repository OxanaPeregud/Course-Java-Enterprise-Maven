package com.peregud.database_sql_person;

import java.util.List;

public interface PersonRepository {

    void personInput(List<Person> list);

    List<Person> personOutput();

}
