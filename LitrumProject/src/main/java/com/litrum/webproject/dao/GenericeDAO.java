package com.litrum.webproject.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Pc on 21/03/2017.
 */
public interface GenericeDAO<T, ID extends Serializable> {

    T getById(ID id, boolean lock);

    T findById(ID id, boolean lock);

    T makePersistent(T entity);

    void makeTransient(T entity);

    long countAll();

    public List<T> findAll();
}
