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
import org.hibernate.ReplicationMode;

import java.sql.SQLException;

public class SessionFactoryStarter {

    public static void main(String[] args) throws DaoException, NoSuchFieldException, IllegalAccessException, SQLException {
        DAOPerson daoPerson = new DAOPersonImpl();
        DAOAddress daoAddress = new DAOAddressImpl();
        daoPerson.save(DataGeneratorUtil.buildPerson());
        daoAddress.save(DataGeneratorUtil.buildAddress());
        System.out.println(daoPerson.get(Person.class, 1));
        System.out.println(daoAddress.get(Address.class, 1));

        Person person1 = Person.builder()
                .id(1)
                .firstName("First Name 1")
                .lastName("Last Name 1")
                .age(20)
                .build();

        Person person2 = Person.builder()
                .id(2)
                .firstName("First Name 2")
                .lastName("Last Name 2")
                .age(20)
                .build();

        daoPerson.replicate(person1, ReplicationMode.OVERWRITE);
        daoPerson.replicate(person2, ReplicationMode.IGNORE);

        AbstractDAO.getUTIL().closeSession();
    }
}
