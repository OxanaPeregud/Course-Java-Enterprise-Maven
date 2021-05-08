package com.peregud.dbprocedure.service;

import com.peregud.dbprocedure.util.DBUtil;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class ProcedureService {
    private static final String SQL_UPDATE_AGE = "{call updateAge (?, ?)}";
    private static final String SQL_UPDATE_ADDRESS = "{call updateAddress (?, ?, ?, ?)}";
    private static final String SQL_DELETE = "{call deletePersonAddress (?, ?)}";
    private static final String SQL_DELETE_UPDATE = "{call deleteAndUpdate (?, ?, ?, ?)}";

    public static void updateAge() {
        Map<Integer, Object> paramIn = new HashMap<>();
        paramIn.put(1, 5);
        Map<Integer, Integer> paramOut = new HashMap<>();
        paramOut.put(2, Types.INTEGER);
        DBUtil.executeProcedure(SQL_UPDATE_AGE, paramIn, paramOut);
    }

    public static void updateAddress() {
        Map<Integer, Object> paramIn = new HashMap<>();
        paramIn.put(1, 5);
        Map<Integer, Integer> paramOut = new HashMap<>();
        paramOut.put(2, Types.VARCHAR);
        paramOut.put(3, Types.INTEGER);
        paramOut.put(4, Types.INTEGER);
        DBUtil.executeProcedure(SQL_UPDATE_ADDRESS, paramIn, paramOut);
    }

    public static void deleteData() {
        Map<Integer, Object> paramIn = new HashMap<>();
        paramIn.put(1, 1);
        paramIn.put(2, 1);
        Map<Integer, Integer> paramOut = new HashMap<>();
        DBUtil.executeProcedure(SQL_DELETE, paramIn, paramOut);
    }

    public static void deleteUpdateData() {
        Map<Integer, Object> paramIn = new HashMap<>();
        paramIn.put(1, 1);
        paramIn.put(2, 1);
        Map<Integer, Integer> paramOut = new HashMap<>();
        paramOut.put(3, Types.INTEGER);
        paramOut.put(4, Types.INTEGER);
        DBUtil.executeProcedure(SQL_DELETE_UPDATE, paramIn, paramOut);
    }
}
