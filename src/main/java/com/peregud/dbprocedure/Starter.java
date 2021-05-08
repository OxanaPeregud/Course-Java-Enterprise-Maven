package com.peregud.dbprocedure;

import com.peregud.dbprocedure.service.BatchService;
import com.peregud.dbprocedure.service.ProcedureService;

public class Starter {

    public static void main(String[] args) {
        BatchService.save();
        ProcedureService.updateAge();
        ProcedureService.updateAddress();
        ProcedureService.deleteData();
        ProcedureService.deleteUpdateData();
    }
}
