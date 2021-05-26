package com.peregud.sessionfactory.exceptions;

import lombok.AllArgsConstructor;
import org.hibernate.HibernateException;

@AllArgsConstructor
public class DaoException extends Exception {
    private final HibernateException message;
}
