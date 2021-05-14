package com.peregud.hibernate;

import com.peregud.hibernate.model.Address;
import com.peregud.hibernate.model.Person;
import com.peregud.hibernate.util.DataBuilderUtil;
import com.peregud.hibernate.util.DataUtil;

public class Starter {
    public static void main(String[] args) {
        DataUtil.persistData(DataBuilderUtil.buildPerson(5));
        DataUtil.persistData(DataBuilderUtil.buildAddress(5));
        System.out.println(DataUtil.getData(1, Person.class));
        System.out.println(DataUtil.getData(2, Address.class));
    }
}
