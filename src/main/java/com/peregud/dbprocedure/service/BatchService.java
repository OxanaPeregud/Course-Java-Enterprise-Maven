package com.peregud.dbprocedure.service;

import com.peregud.dbprocedure.util.DBUtil;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

public class BatchService {
    private static final List<String> SQL_LIST = Arrays.asList(
            "INSERT INTO personDB.person VALUES (1, 'James', 'Smith', 50)",
            "INSERT INTO personDB.person VALUES (2, 'Robert', 'Johnson', 37)",
            "INSERT INTO personDB.person VALUES (3, 'Michael', 'Williams', 12)",
            "INSERT INTO personDB.person VALUES (4, 'David', 'Brown', 25)",
            "INSERT INTO personDB.person VALUES (5, 'Richard', 'Jones', 18)",
            "INSERT INTO personDB.address VALUES (1, 'Wall Street', 11, 125)",
            "INSERT INTO personDB.address VALUES (2, 'Broadway', 7, 109)",
            "INSERT INTO personDB.address VALUES (3, 'Bowery', 28, 43)",
            "INSERT INTO personDB.address VALUES (4, 'Houston Street', 33, 150)",
            "INSERT INTO personDB.address VALUES (5, 'Canal Street', 45, 211)",
            "INSERT INTO personDB.person_address VALUES (1, 1, 2)",
            "INSERT INTO personDB.person_address VALUES (2, 2, 2)",
            "INSERT INTO personDB.person_address VALUES (3, 3, 1)",
            "INSERT INTO personDB.person_address VALUES (4, 4, 5)",
            "INSERT INTO personDB.person_address VALUES (5, 5, 4)");
    private DataSource ds;

    public BatchService(DataSource ds) {
        this.ds = ds;
    }

    public static void save() {
        DBUtil.executeBatch(SQL_LIST);
    }
}
