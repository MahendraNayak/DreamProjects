package com.litrum.webproject.dao;

import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Pc on 21/03/2017.
 */
@Repository
public abstract class GenericDAOHibernate<T, ID extends Serializable>
        implements GenericeDAO<T, ID> {

    private static final Logger logger = LoggerFactory.getLogger(GenericDAOHibernate.class);
    private Class<T> persistentClass;
    private Session session;

    @SuppressWarnings("unchecked")
    public GenericDAOHibernate() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    protected Session getSession() {
        if (session == null)
            throw new IllegalStateException("Session has not been set on DAO before usage");
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }


    @SuppressWarnings("unchecked")
    public T getById(ID id, boolean lock) {
        T entity;
        if (lock)
            entity = (T) getSession().get(getPersistentClass(), id, new LockOptions(LockMode.PESSIMISTIC_WRITE));
        else
            entity = (T) getSession().get(getPersistentClass(), id);
        return entity;
    }

    @SuppressWarnings("unchecked")
    public T findById(ID id, boolean lock) {
        T entity;
        if (lock)
            entity = (T) getSession().load(getPersistentClass(), id, new LockOptions(LockMode.PESSIMISTIC_WRITE));
        else
            entity = (T) getSession().load(getPersistentClass(), id);

        return entity;
    }

    public long countAll() {
        return countByCriteria();
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        return crit.list();
    }

    @SuppressWarnings("unchecked")
    public T makePersistent(T entity) {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    public void makeTransient(T entity) {
        getSession().delete(entity);
    }

    protected long countByCriteria(Criterion... criterion) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        crit.setProjection(Projections.rowCount());
        return (Long) crit.uniqueResult();
    }
}
