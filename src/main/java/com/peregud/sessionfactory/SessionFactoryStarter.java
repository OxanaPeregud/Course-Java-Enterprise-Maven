package com.peregud.sessionfactory;

import com.peregud.sessionfactory.dao.DAOAddress;
import com.peregud.sessionfactory.dao.DAOPerson;
import com.peregud.sessionfactory.dao.impl.AbstractDAO;
import com.peregud.sessionfactory.dao.impl.DAOAddressImpl;
import com.peregud.sessionfactory.dao.impl.DAOPersonImpl;
import com.peregud.sessionfactory.exceptions.DaoException;
import com.peregud.sessionfactory.model.Address;
import com.peregud.sessionfactory.model.Person;
import com.peregud.sessionfactory.util.DataGeneratorUtil;

import java.sql.SQLException;

public class SessionFactoryStarter {

    public static void main(String[] args) throws DaoException, NoSuchFieldException, IllegalAccessException, SQLException {
        DAOPerson daoPerson = new DAOPersonImpl();
        DAOAddress daoAddress = new DAOAddressImpl();
        daoPerson.save(DataGeneratorUtil.buildPerson());
        daoAddress.save(DataGeneratorUtil.buildAddress());
        System.out.println(daoPerson.get(Person.class, 1));
        System.out.println(daoAddress.get(Address.class, 1));
        daoPerson.update(Person.class, 2, "age", 30);
        daoAddress.update(Address.class, 2, "house", 150);
        daoPerson.delete(Person.class, 3);
        daoAddress.delete(Address.class, 3);
        daoPerson.callProcedure("updateAge", 1);
        AbstractDAO.getUTIL().closeSession();
    }
}
