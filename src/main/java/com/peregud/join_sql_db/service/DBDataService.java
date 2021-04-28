package com.peregud.join_sql_db.service;

public interface DBDataService {

    void saveNewData();

    void getByID(int id);

    void updateData(int id, int change);

    void deleteData(int id);

    void displayAll();

}
