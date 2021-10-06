package com.spring_rust_313.dao;

import com.spring_rust_313.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
    Role findRoleByName(String roleName);

}
