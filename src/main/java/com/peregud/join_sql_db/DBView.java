package com.peregud.join_sql_db;

import java.util.List;

public class DBView<T> {

    public void display(List<T> list) {
        if (list != null) {
            list.forEach(System.out::println);
        }
    }
}
