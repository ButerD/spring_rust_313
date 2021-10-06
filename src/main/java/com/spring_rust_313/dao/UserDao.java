package com.spring_rust_313.dao;


import com.spring_rust_313.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findUserByName(String name);
    User findUserByEmail(String email);
}
