package com.spring_rust_313.service;


import com.spring_rust_313.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService  {
    List<User> getAllUsers();
    void addUser(User user);
    void removeUser(Long id);
    User getUser(Long id);
    void updateUser(User user);
    User findByUserName(String name);
    User findByEmail(String name);
}
