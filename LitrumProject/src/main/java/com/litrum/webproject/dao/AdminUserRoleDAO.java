package com.litrum.webproject.dao;

import com.litrum.webproject.model.AdminUserRole;

/**
 * Created by Pc on 25/03/2017.
 */
public interface AdminUserRoleDAO extends GenericeDAO<AdminUserRole, Long> {

    AdminUserRole findAdminUserRoleByName(String userRoleName);

    boolean isExistAdminUserRoleByName(String userRoleName);
}
