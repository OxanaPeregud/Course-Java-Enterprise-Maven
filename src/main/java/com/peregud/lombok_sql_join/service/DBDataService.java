package com.peregud.lombok_sql_join.service;

import java.util.List;

public interface DBDataService<T> {

    void saveNewData(List<T> list);

    void getByID(int id);

    void updateData(int id, int change);

    void deleteData(int id);

    void displayAll();

}
