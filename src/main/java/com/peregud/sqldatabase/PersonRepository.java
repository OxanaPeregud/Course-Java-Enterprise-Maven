package com.peregud.sqldatabase;

import java.util.List;

public interface PersonRepository {

    void personInput(List<Person> list);

    List<Person> personOutput();

}
