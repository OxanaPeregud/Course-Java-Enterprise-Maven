package com.peregud.hibernate;

import com.peregud.hibernate.model.Address;
import com.peregud.hibernate.model.Person;
import com.peregud.hibernate.util.DataBuilderUtil;
import com.peregud.hibernate.util.DataUtil;

public class Starter {
    public static void main(String[] args) {
        DataUtil.persistData(DataBuilderUtil.buildPerson(5));
        DataUtil.persistData(DataBuilderUtil.buildAddress(5));
        System.out.println(DataUtil.findData(Person.class, 2));
        System.out.println(DataUtil.findData(Address.class, 2));
        DataUtil.updateAge(1);
        DataUtil.updateAgeProcedure(1);
        DataUtil.updateAddress(1);
        DataUtil.removeData(Person.class, 5);
        DataUtil.removeData(Address.class, 5);
    }
}
