package com.litrum.webproject.dao;

import com.litrum.webproject.model.EndUserRole;

/**
 * Created by Pc on 24/03/2017.
 */
public interface EndUserRoleDAO extends GenericeDAO<EndUserRole, Long> {

    EndUserRole findByRoleName(String roleName);
}
