package com.spring_rust_313.service;


import com.spring_rust_313.model.Role;

import java.util.List;

public interface RoleService {
    Role getById(Long id);
    Role findRoleByName(String rolename);
    List<Role> getAllRoles();
}
