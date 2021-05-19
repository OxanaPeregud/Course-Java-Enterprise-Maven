package com.peregud.sessionfactory;

import com.peregud.sessionfactory.exceptions.DaoException;
import com.peregud.sessionfactory.util.DataUtil;
import com.peregud.sessionfactory.util.SessionUtil;

public class Starter {
    public static void main(String[] args) throws DaoException {
        SessionUtil sessionUtil = new SessionUtil();
        DataUtil.callProcedure("updateAge", 150);
        sessionUtil.closeSession();
    }
}
