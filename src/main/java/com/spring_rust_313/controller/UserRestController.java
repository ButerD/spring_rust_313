package com.spring_rust_313.controller;

import com.spring_rust_313.model.Role;
import com.spring_rust_313.model.User;
import com.spring_rust_313.service.RoleService;
import com.spring_rust_313.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserRestController {

    UserService userService;
    RoleService roleService;

    @Autowired
    public UserRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("admin/users")
    public List<User> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users;
    }

    @GetMapping("admin/{id}")
    public User getUserById(@PathVariable long id) {
        User user = userService.getUser(id);
        return user;
    }

    @GetMapping("admin/authorities")
    public List<Role> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return roles;
    }

    @PostMapping(value = "admin")
    public User addNewUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @PutMapping("admin")
    public User updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return user;
    }

    @DeleteMapping("admin/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.removeUser(id);
        return "Id " + id + "deleted";
    }



}
