package com.peregud.dbprocedure;

import com.peregud.dbprocedure.service.BatchService;
import com.peregud.dbprocedure.service.ProcedureService;

public class DBProcedureStarter {

    public static void start() {
        BatchService.save();
        ProcedureService.updateAge();
        ProcedureService.updateAddress();
        ProcedureService.deleteData();
        ProcedureService.deleteUpdateData();
    }
}
