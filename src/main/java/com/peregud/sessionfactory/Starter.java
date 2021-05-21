package com.peregud.sessionfactory;

import com.peregud.sessionfactory.dao.DAOAddress;
import com.peregud.sessionfactory.dao.DAOPerson;
import com.peregud.sessionfactory.dao.impl.DAOAddressImpl;
import com.peregud.sessionfactory.dao.impl.DAOPersonImpl;
import com.peregud.sessionfactory.exceptions.DaoException;
import com.peregud.sessionfactory.model.Address;
import com.peregud.sessionfactory.model.Person;
import com.peregud.sessionfactory.util.DataGeneratorUtil;
import com.peregud.sessionfactory.dao.impl.DAOImpl;

import java.sql.SQLException;

public class Starter {
    public static void main(String[] args)
            throws DaoException, NoSuchFieldException, IllegalAccessException, SQLException {
        DAOImpl<Person> dao = new DAOImpl<>();
        DAOPerson daoPerson = new DAOPersonImpl();
        DAOAddress daoAddress = new DAOAddressImpl();
        daoPerson.save(DataGeneratorUtil.buildPerson());
        daoAddress.save(DataGeneratorUtil.buildAddress());
        System.out.println(daoPerson.get(Person.class, 165));
        System.out.println(daoAddress.get(Address.class, 10));
        daoPerson.update(Person.class, 165, "age", 30);
        daoAddress.update(Address.class, 10, "house", 150);
        daoPerson.delete(Person.class, 171);
        daoAddress.delete(Address.class, 12);
        dao.callProcedure("updateAge", 165);
        DAOImpl.getUTIL().closeSession();
    }
}
