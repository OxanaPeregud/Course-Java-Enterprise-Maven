package com.peregud.lombok.view;

import java.sql.SQLException;
import java.util.List;

public interface DBView<T> {

    void displayByID(T t) throws SQLException;

    void displayAllData(List<T> list) throws SQLException;

}
