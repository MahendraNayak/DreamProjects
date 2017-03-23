package com.litrum.webproject.dao;

import com.litrum.webproject.model.ServiceOffered;

/**
 * Created by Pc on 24/03/2017.
 */
public interface ServiceOfferedDAO extends GenericeDAO<ServiceOffered, Long> {

    ServiceOffered findServiceOfferedByName(String name);

}
