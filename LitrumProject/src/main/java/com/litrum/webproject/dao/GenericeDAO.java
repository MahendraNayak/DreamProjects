package com.litrum.webproject.dao;

import java.io.Serializable;

/**
 * Created by Pc on 21/03/2017.
 */
public interface GenericeDAO<T, ID extends Serializable> {

    T getById(ID id, boolean lock);

    T findById(ID id, boolean lock);

    T makePersistent(T entity);

    void makeTransient(T entity);

    long countAll();
}
