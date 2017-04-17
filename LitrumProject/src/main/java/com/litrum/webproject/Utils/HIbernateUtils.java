package com.litrum.webproject.Utils;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

/**
 * Created by Pc on 18/04/2017.
 */
public class HIbernateUtils {

    public static <T> T unproxy(T proxied) {
        T entity = proxied;
        if (entity instanceof HibernateProxy) {
            Hibernate.initialize(entity);
            entity = (T) ((HibernateProxy) entity)
                    .getHibernateLazyInitializer()
                    .getImplementation();
        }
        return entity;
    }
}
