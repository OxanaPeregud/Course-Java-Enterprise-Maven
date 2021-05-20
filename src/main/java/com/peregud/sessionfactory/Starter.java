package com.peregud.sessionfactory;

import com.peregud.sessionfactory.dao.DAOAddress;
import com.peregud.sessionfactory.dao.DAOPerson;
import com.peregud.sessionfactory.dao.impl.DAOAddressImpl;
import com.peregud.sessionfactory.dao.impl.DAOPersonImpl;
import com.peregud.sessionfactory.exceptions.DaoException;
import com.peregud.sessionfactory.util.DataGeneratorUtil;
import com.peregud.sessionfactory.util.DataUtil;

import java.sql.SQLException;

public class Starter {
    public static void main(String[] args)
            throws DaoException, NoSuchFieldException, IllegalAccessException, SQLException {
        DAOPerson daoPerson = new DAOPersonImpl();
        DAOAddress daoAddress = new DAOAddressImpl();
        daoPerson.save(DataGeneratorUtil.buildPerson());
        daoAddress.save(DataGeneratorUtil.buildAddress());
        System.out.println(daoPerson.get(165));
        System.out.println(daoAddress.get(10));
        daoPerson.update(164, 30);
        daoAddress.update(10, 150);
        daoPerson.delete(171);
        daoAddress.delete(12);
        DataUtil.callProcedure("updateAge", 165);
        DataUtil.getUTIL().closeSession();
    }
}
